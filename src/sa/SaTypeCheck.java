package sa;
import util.Type;
import util.Error;
import ts.*;

public class SaTypeCheck extends SaDepthFirstVisitor <Void>{
    private TsItemFct fonctionCourante;

    public SaTypeCheck(SaNode root)
    {
	try{
	root.accept(this);
	}
	catch(ErrorException e){
	    System.err.print("ERREUR DE TYPAGE : ");
	    System.err.println(e.getMessage());
	    System.exit(e.getCode());
	}
	catch(Exception e){}
    }

    // P -> LDEC LDEC
    public Void visit(SaProg node) throws Exception
    {
        defaultIn(node);
        if(node.getVariables() != null)
            node.getVariables().accept(this);
        if(node.getFonctions() != null)
            node.getFonctions().accept(this);
        defaultOut(node);
        return null;
    }

    // DEC -> var id taille
    public Void visit(SaDecTab node) throws Exception{
        defaultIn(node);
        defaultOut(node);
        return null;
    }

    public Void visit(SaExp node) throws Exception
    {
        defaultIn(node);
        defaultOut(node);
        return null;
    }

    // EXP -> entier
    public Void visit(SaExpInt node) throws Exception
    {
        defaultIn(node);
        defaultOut(node);
        return null;
    }

    // EXP -> vrai
    public Void visit(SaExpVrai node) throws Exception
    {
        defaultIn(node);
        defaultOut(node);
        return null;
    }

    // EXP -> faux
    public Void visit(SaExpFaux node) throws Exception
    {
        defaultIn(node);
        defaultOut(node);
        return null;
    }

    public Void visit(SaExpVar node) throws Exception
    {
        defaultIn(node);
        node.getVar().accept(this);
        defaultOut(node);
        return null;
    }

    public Void visit(SaInstEcriture node) throws Exception
    {
        defaultIn(node);
        node.getArg().accept(this);
        defaultOut(node);
        return null;
    }

    public Void visit(SaInstTantQue node) throws Exception
    {
        defaultIn(node);
        node.getTest().accept(this);
        if (node.getFaire() != null)
            node.getFaire().accept(this);
        defaultOut(node);
        return null;
    }
    public Void visit(SaLInst node) throws Exception
    {
        defaultIn(node);
        if(node != null){
            if(node.getTete() != null)node.getTete().accept(this);
            if(node.getQueue() != null) node.getQueue().accept(this);
        }
        defaultOut(node);
        return null;
    }

    // DEC -> fct id LDEC LDEC LINST
    public Void visit(SaDecFonc node) throws Exception
    {
        defaultIn(node);
        if(node.getParametres() != null) node.getParametres().accept(this);
        if(node.getVariable() != null) node.getVariable().accept(this);
        if(node.getCorps() != null) node.getCorps().accept(this);
        defaultOut(node);
        return null;
    }

    // DEC -> var id
    public Void visit(SaDecVar node) throws Exception
    {
        defaultIn(node);
        defaultOut(node);
        return null;
    }

    public Void visit(SaInstAffect node) throws Exception
    {
        defaultIn(node);
        node.getLhs().accept(this);
        node.getRhs().accept(this);
        defaultOut(node);
        return null;
    }

    // LDEC -> DEC LDEC
    // LDEC -> null
    /*    public Void visit(SaLDec node) throws Exception
    {
	defaultIn(node);
	node.getTete().accept(this);
	if(node.getQueue() != null) node.getQueue().accept(this);
	defaultOut(node);
	return null;
	}*/

    public Void visit(SaLDecVar node) throws Exception
    {
        defaultIn(node);
        node.getTete().accept(this);
        if(node.getQueue() != null) node.getQueue().accept(this);
        defaultOut(node);
        return null;
    }

    public Void visit(SaLDecFonc node) throws Exception
    {
        defaultIn(node);
        node.getTete().accept(this);
        if(node.getQueue() != null) node.getQueue().accept(this);
        defaultOut(node);
        return null;
    }

    public Void visit(SaVarSimple node) throws Exception
    {
        defaultIn(node);
        defaultOut(node);
        return null;
    }

    public Void visit(SaAppel node) throws Exception
    {
        defaultIn(node);
        if(node.getArguments() != null) node.getArguments().accept(this);
        defaultOut(node);
        return null;
    }

    public Void visit(SaExpAppel node) throws Exception
    {
        defaultIn(node);
        node.getVal().accept(this);
        defaultOut(node);
        return null;
    }

    // EXP -> add EXP EXP
    public Void visit(SaExpAdd node) throws Exception
    {
        defaultIn(node);
        node.getOp1().accept(this);
        node.getOp2().accept(this);
        defaultOut(node);
        return null;
    }

    // EXP -> sub EXP EXP
    public Void visit(SaExpSub node) throws Exception
    {
        defaultIn(node);
        node.getOp1().accept(this);
        node.getOp2().accept(this);
        defaultOut(node);
        return null;
    }

    // EXP -> mult EXP EXP
    public Void visit(SaExpMult node) throws Exception
    {
        defaultIn(node);
        node.getOp1().accept(this);
        node.getOp2().accept(this);
        defaultOut(node);
        return null;
    }

    // EXP -> div EXP EXP
    public Void visit(SaExpDiv node) throws Exception
    {
        defaultIn(node);
        node.getOp1().accept(this);
        node.getOp2().accept(this);
        defaultOut(node);
        return null;
    }

    // EXP -> inf EXP EXP
    public Void visit(SaExpInf node) throws Exception
    {
        defaultIn(node);
        node.getOp1().accept(this);
        node.getOp2().accept(this);
        defaultOut(node);
        return null;
    }

    // EXP -> eq EXP EXP
    public Void visit(SaExpEqual node) throws Exception
    {
        defaultIn(node);
        node.getOp1().accept(this);
        node.getOp2().accept(this);
        defaultOut(node);
        return null;
    }

    // EXP -> and EXP EXP
    public Void visit(SaExpAnd node) throws Exception
    {
        defaultIn(node);
        node.getOp1().accept(this);
        node.getOp2().accept(this);
        defaultOut(node);
        return null;
    }


    // EXP -> or EXP EXP
    public Void visit(SaExpOr node) throws Exception
    {
        defaultIn(node);
        node.getOp1().accept(this);
        node.getOp2().accept(this);
        defaultOut(node);
        return null;
    }

    // EXP -> not EXP
    public Void visit(SaExpNot node) throws Exception
    {
        defaultIn(node);
        node.getOp1().accept(this);
        defaultOut(node);
        return null;
    }


    public Void visit(SaExpLire node) throws Exception
    {
        defaultIn(node);
        defaultOut(node);
        return null;
    }

    public Void visit(SaInstBloc node) throws Exception
    {
        defaultIn(node);
        node.getVal().accept(this);
        defaultOut(node);
        return null;
    }

    public Void visit(SaInstSi node) throws Exception
    {
        defaultIn(node);
        node.getTest().accept(this);
        if (node.getAlors() != null)
            node.getAlors().accept(this);
        if(node.getSinon() != null) node.getSinon().accept(this);
        defaultOut(node);
        return null;
    }

    // INST -> ret EXP
    public Void visit(SaInstRetour node) throws Exception
    {
        defaultIn(node);
        node.getVal().accept(this);
        defaultOut(node);
        return null;
    }


    public Void visit(SaLExp node) throws Exception
    {
        defaultIn(node);
        node.getTete().accept(this);
        if(node.getQueue() != null)
            node.getQueue().accept(this);
        defaultOut(node);
        return null;
    }
    public Void visit(SaVarIndicee node) throws Exception
    {
        defaultIn(node);
        node.getIndice().accept(this);
        defaultOut(node);
        return null;
    }


    public void defaultIn(SaNode node)
    {
	//			System.out.println("<" + node.getClass().getSimpleName() + ">");
    }

    public void defaultOut(SaNode node)
    {
	//		System.out.println("</" + node.getClass().getSimpleName() + ">");
    }



}
