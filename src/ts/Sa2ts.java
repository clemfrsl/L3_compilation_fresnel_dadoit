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


		SaLDecVar maillon;
		for(maillon = node.getParametres(), nbArgs = 0; maillon != null; maillon = maillon.getQueue(), nbArgs++ );

		if(this.tableGlobale.getFct(identif) != null)
			throw new ErrorException(Error.TS, "Function already exist.");
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
		this.context = Context.GLOBAL;
		defaultOut(node);
		return null;
	}

	@Override
	// DEC -> var id taille
	public Void visit(SaDecTab node) throws Exception {
		defaultIn(node);
		String identif = node.getNom();
		if(this.context == Context.GLOBAL){
			if(this.tableGlobale.getVar(identif) != null)
				throw new ErrorException(Error.TS, "Variable already exist.");
			node.tsItem = tableGlobale.addTab(identif, node.getType(), node.getTaille());
		}
		else {
			if(this.tableLocaleCourante.getVar(identif) != null)
				throw new ErrorException(Error.TS, "Variable already exist.");
			if(this.context == Context.LOCAL){
				tableGlobale.addTab(identif, node.getType(), node.getTaille());
			}
			if(this.context == Context.PARAM){
				tableGlobale.addParam(identif, node.getType());
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
		if(this.context == Context.GLOBAL){
			if(tableGlobale.getVar(identif) != null)
				throw new ErrorException(Error.TS, "Variable already exist.");
			tableGlobale.addVar(identif, node.getType());
		}
		else {
			if(tableLocaleCourante.getVar(identif) != null)
				throw new ErrorException(Error.TS, "Variable already exist.");
			if(this.context == Context.PARAM)
				tableLocaleCourante.addParam(identif, node.getType());
			else
				tableLocaleCourante.addVar(identif, node.getType());
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
		TsItemVar item;
		item = tableGlobale.getVar(node.getNom());
		if(item == null ){
			throw new ErrorException(Error.TS, "Var not found");
		}
		if(!(item instanceof TsItemVarTab))
			throw new ErrorException(Error.TS, "Error");
		if(node.getIndice() == null)
			throw new ErrorException(Error.TS, "Indice not found");
		node.tsItem = item;

		node.getIndice().accept(this);
		defaultOut(node);
		return null;
	}

	@Override
	public Void visit(SaAppel node) throws Exception
	{
		defaultIn(node);
		TsItemFct item = null;
		String identif = node.getNom();
		int nbArg = node.getArguments().length();
		item = tableGlobale.getFct(identif);
		if( item != null){
			node.tsItem = item;
			if(nbArg != tableGlobale.getFct(identif).getNbArgs())
				throw new ErrorException(Error.TS, "Wrong number of arguments");
		}
		else
			throw new ErrorException(Error.TS, "Function does not exist");
		defaultOut(node);
		return null;
	}
}
