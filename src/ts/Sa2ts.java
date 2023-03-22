package ts;
import sa.*;
import util.Error;

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
		if(context != Context.GLOBAL){
				throw new Exception("Le contexte n'est pas global.");
		}
		TsItemFct item = tableGlobale.getFct(node.tsItem.getIdentif());
		if(item != null){
			throw new Exception("La fonction est deja existante.");
		}
		node.tsItem = item;
		tableGlobale.addFct(node.getNom(), node.getTypeRetour(), node.getParametres().length(), tableGlobale, node);
		if(node.getParametres() != null) node.getParametres().accept(this);
		if(node.getVariable() != null) node.getVariable().accept(this);
		if(node.getCorps() != null) node.getCorps().accept(this);
		defaultOut(node);
		return null;
	}

	@Override
	// DEC -> var id taille
	public Void visit(SaDecTab node) throws Exception{
		defaultIn(node);
		TsItemVar item =null;
		if(context == Context.GLOBAL){
			item = tableGlobale.getVar(node.getNom());
			if( item != null){
				throw new ErrorException(Error.TS, "Variable globale deja utilisée");
			}
			node.tsItem = item;
			tableGlobale.addTab(node.getNom(), node.getType(), node.getTaille());
		}

		else{
			item = tableLocaleCourante.getVar(node.getNom());
			if(item != null){
				throw new ErrorException(Error.TS, "Variable locale deja utilisée");
			}
			node.tsItem = item;
			if(context == Context.PARAM){
				tableLocaleCourante.addParam(node.getNom(), node.getType());
			}
			else{
				tableLocaleCourante.addTab(node.getNom(), node.getType(), node.getTaille());
			}
		}
		defaultOut(node);
		return null;
	}

	@Override
	// DEC -> var id
    public Void visit(SaDecVar node) throws Exception {
		defaultIn(node);
		TsItemVar item = null;
		if(context == Context.GLOBAL){
			item = tableGlobale.getVar(node.getNom());
			if( item != null){
				throw new ErrorException(Error.TS, "Variable globale deja utilisée");
			}
			node.setTsItem(item);
			tableGlobale.addVar(node.getNom(), node.getType());
		}
		else{
			item = tableLocaleCourante.getVar(node.getNom());
			if(item != null){
				throw new ErrorException(Error.TS, "Variable locale deja utilisée");
			}
			node.setTsItem(item);
			if(context == Context.PARAM){
				tableLocaleCourante.addParam(node.getNom(), node.getType());
			}
			else{
				tableLocaleCourante.addVar(node.getNom(), node.getType());
			}
		}
		defaultOut(node);
		return null;
    }

	@Override
	public Void visit(SaVarSimple node) throws Exception
	{
		defaultIn(node);
		TsItemVar item = null;
		if(context == Context.GLOBAL){
			item = tableGlobale.getVar(node.getNom());
			if(item == null ){
				throw new ErrorException(Error.TS, "Variable globale pas trouvée");
			}
			node.tsItem = (TsItemVarSimple) item;
		}

		else{
			item = tableLocaleCourante.getVar(node.getNom());
			if(item == null){
				throw new ErrorException(Error.TS, "Variable locale pas trouvée");
			}
			node.tsItem = (TsItemVarSimple) item;
		}
		defaultOut(node);
		return null;
	}

	@Override
	//todo
	public Void visit(SaVarIndicee node) throws Exception
	{
		defaultIn(node);
		TsItemVar item = null;
		if(context == Context.GLOBAL){
			item = tableGlobale.getVar(node.getNom());
			if(item == null ){
				throw new ErrorException(Error.TS, "Variable globale pas trouvée");
			}
			node.tsItem = item;
		}

		else{
			item = tableLocaleCourante.getVar(node.getNom());
			if(item == null){
				throw new ErrorException(Error.TS, "Variable locale pas trouvée");
			}
			node.tsItem = item;
		}
		node.getIndice().accept(this);
		defaultOut(node);
		return null;
	}

	@Override
	//todo
	public Void visit(SaAppel node) throws Exception
	{
		defaultIn(node);

		/*Toute variable utilisée est déclarée en tant que (recherche dans l’ordre) :
— (1) Variable locale ou (2) argument de fonction ou (3) variable globale.
— Les tableaux ne peuvent pas être utilisés sans indice
— Les variables simples ne peuvent pas être indicés
— Aucune conversion ou coercition n’est possible
		 */
		if(node.getArguments() != null) node.getArguments().accept(this);
		defaultOut(node);
		return null;
	}
}
