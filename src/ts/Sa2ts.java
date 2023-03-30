package ts;
import sa.*;
import util.Error;
import util.Type;

public class Sa2ts extends SaDepthFirstVisitor <Void> {
	enum Context {
		LOCAL,
		GLOBAL,
		PARAM
	}

	private Ts tableGlobale;
	private Ts tableLocaleCourante;
	private Context context;

	public Ts getTableGlobale(){return this.tableGlobale;}

	public Sa2ts(SaNode root)
	{
		tableGlobale = new Ts();
		tableLocaleCourante = null;
		context = Context.GLOBAL;
		try{
			root.accept(this);
			if(tableGlobale.getFct("main") == null)
				throw new ErrorException(Error.TS, "la fonction main n'est pas définie");
		}
		catch(ErrorException e){
			System.err.print("ERREUR TABLE DES SYMBOLES : ");
			System.err.println(e.getMessage());
			System.exit(e.getCode());
		}
		catch(Exception e){}
	}

	@Override
	// DEC -> fct id LDEC LDEC LINST
	public Void visit(SaDecFonc node) throws Exception
	{
		defaultIn(node);
		this.tableLocaleCourante = new Ts();
		String identif = node.getNom();
		Type typeRetour = node.getTypeRetour();
		int nbArgs = 0;

		if(this.tableGlobale.getFct(identif) != null)
			throw new ErrorException(Error.TS, "Function already exist.");

		SaLDecVar maillon;
		for(maillon = node.getParametres(), nbArgs = 0; maillon != null; maillon = maillon.getQueue(), nbArgs++ );

		node.tsItem = tableGlobale.addFct(identif, typeRetour, nbArgs, tableLocaleCourante, node);

		this.context = Context.PARAM;
		if(node.getParametres() != null)
			node.getParametres().accept(this);

		this.context = Context.LOCAL;
		if(node.getVariable() != null){
			node.getVariable().accept(this);
		}

		if(node.getCorps() != null){
			node.getCorps().accept(this);
		}
		node.tsItem = tableGlobale.getFct(identif);
		this.context = Context.GLOBAL;
		defaultOut(node);
		return null;
	}

	@Override
	// DEC -> var id taille
	public Void visit(SaDecTab node) throws Exception {
		defaultIn(node);
		String identif = node.getNom();
		Type type = node.getType();
		int taille = node.getTaille();
		if(this.context == Context.GLOBAL){
			if(this.tableGlobale.getVar(identif) != null)
				throw new ErrorException(Error.TS, "Variable already exist.");
			node.setTsItem(tableGlobale.addTab(identif, type, taille));
		}
		else {
			if(this.tableLocaleCourante.getVar(identif) != null)
				throw new ErrorException(Error.TS, "Variable already exist.");
			if(this.context == Context.LOCAL){
				node.setTsItem(tableGlobale.addTab(identif, type, taille));
			}
			if(this.context == Context.PARAM){
				node.setTsItem(tableGlobale.addParam(identif, type));
			}
		}
		defaultOut(node);
		return null;
	}

	@Override
	// DEC -> var id
	public Void visit(SaDecVar node) throws Exception {
		defaultIn(node);
		String identif = node.getNom();
		Type type = node.getType();

		if(this.context == Context.GLOBAL){
			if(tableGlobale.getVar(identif) != null)
				throw new ErrorException(Error.TS, "Variable already exist.");
			node.setTsItem(tableGlobale.addVar(identif, type));
		}
		else {
			if(tableLocaleCourante.getVar(identif) != null)
				throw new ErrorException(Error.TS, "Variable already exist.");
			if(this.context == Context.PARAM)
				node.setTsItem(tableLocaleCourante.addParam(identif, type));
			else
				node.setTsItem(tableLocaleCourante.addVar(identif, type));
		}
		defaultOut(node);
		return null;
	}

	@Override
	public Void visit(SaVarSimple node) throws Exception
	{
		defaultIn(node);
		String identif = node.getNom();
		if(tableLocaleCourante.getVar(identif) != null){
			if(!(tableLocaleCourante.getVar(identif) instanceof TsItemVarSimple))
				throw new ErrorException(Error.TS, "Should have index");
			node.tsItem = (TsItemVarSimple) tableLocaleCourante.getVar(identif);
		}
		else if(tableGlobale.getVar(identif) != null){
			if(!(tableGlobale.getVar(identif) instanceof TsItemVarSimple))
				throw new ErrorException(Error.TS, "Should have index");
			node.tsItem = (TsItemVarSimple) tableGlobale.getVar(identif);
		} else
			throw new ErrorException(Error.TS, "Var not found");
		defaultOut(node);
		return null;
	}

	@Override
	public Void visit(SaVarIndicee node) throws Exception
	{
		defaultIn(node);
		String identif = node.getNom();
		if(tableGlobale.getVar(identif) == null )
			throw new ErrorException(Error.TS, "Var not found");

		if(!((tableGlobale.getVar(identif)) instanceof TsItemVarTab))
			throw new ErrorException(Error.TS, "Error");
		if(node.getIndice() == null)
			throw new ErrorException(Error.TS, "Indice not found");
		node.tsItem = tableGlobale.getVar(identif);
		node.getIndice().accept(this);
		defaultOut(node);
		return null;
	}

	@Override
	public Void visit(SaAppel node) throws Exception
	{
		defaultIn(node);
		SaLExp param = node.getArguments();
		int taille = 0;
		if(param != null){
			param.accept(this);
			taille = param.length();
		}
		if(tableGlobale.getFct(node.getNom()) == null)
			throw new ErrorException(Error.TS, "Function does not exist");
		if(taille != tableGlobale.getFct(node.getNom()).nbArgs)
			throw new ErrorException(Error.TS, "Wrong number of arguments");
		node.tsItem = tableGlobale.getFct(node.getNom());
		defaultOut(node);
		return null;
	}
}
