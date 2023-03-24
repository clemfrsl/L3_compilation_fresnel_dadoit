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
    public void visit(SaProg node) throws Exception
    {
        defaultIn(node);
        if(node.getVariables() != null)
            node.getVariables().accept(this);
        if(node.getFonctions() != null)
            node.getFonctions().accept(this);
        defaultOut(node);
    }

    // DEC -> var id taille
    public void visit(SaDecTab node) throws Exception{
        defaultIn(node);
        defaultOut(node);
    }

    public void visit(SaExp node) throws Exception
    {
        defaultIn(node);
        defaultOut(node);
    }

    // EXP -> entier
    public void visit(SaExpInt node) throws Exception
    {
        defaultIn(node);
        defaultOut(node);
    }

    // EXP -> vrai
    public void visit(SaExpVrai node) throws Exception
    {
        defaultIn(node);
        defaultOut(node);
    }

    // EXP -> faux
    public void visit(SaExpFaux node) throws Exception
    {
        defaultIn(node);
        defaultOut(node);
    }

    public void visit(SaExpVar node) throws Exception
    {
        defaultIn(node);
        node.getVar().accept(this);
        defaultOut(node);
    }

    public void visit(SaInstEcriture node) throws Exception
    {
        defaultIn(node);
        node.getArg().accept(this);
        defaultOut(node);
    }

    public void visit(SaInstTantQue node) throws Exception
    {
        defaultIn(node);
        node.getTest().accept(this);
        if (node.getFaire() != null)
            node.getFaire().accept(this);
        defaultOut(node);
    }
    public void visit(SaLInst node) throws Exception
    {
        defaultIn(node);
        if(node != null){
            if(node.getTete() != null)node.getTete().accept(this);
            if(node.getQueue() != null) node.getQueue().accept(this);
        }
        defaultOut(node);
    }

    // DEC -> fct id LDEC LDEC LINST
    public void visit(SaDecFonc node) throws Exception
    {
        defaultIn(node);
        if(node.getParametres() != null) node.getParametres().accept(this);
        if(node.getVariable() != null) node.getVariable().accept(this);
        if(node.getCorps() != null) node.getCorps().accept(this);
        defaultOut(node);
    }

    // DEC -> var id
    public void visit(SaDecVar node) throws Exception
    {
        defaultIn(node);
        defaultOut(node);
    }

    public void visit(SaInstAffect node) throws Exception
    {
        defaultIn(node);
        node.getLhs().accept(this);
        node.getRhs().accept(this);
        defaultOut(node);
    }

    // LDEC -> DEC LDEC
    // LDEC -> null
    /*    public void visit(SaLDec node) throws Exception
    {
	defaultIn(node);
	node.getTete().accept(this);
	if(node.getQueue() != null) node.getQueue().accept(this);
	defaultOut(node);

	}*/

    public void visit(SaLDecVar node) throws Exception
    {
        defaultIn(node);
        node.getTete().accept(this);
        if(node.getQueue() != null) node.getQueue().accept(this);
        defaultOut(node);
    }

    public void visit(SaLDecFonc node) throws Exception
    {
        defaultIn(node);
        node.getTete().accept(this);
        if(node.getQueue() != null) node.getQueue().accept(this);
        defaultOut(node);
    }

    public void visit(SaVarSimple node) throws Exception
    {
        defaultIn(node);
        defaultOut(node);
    }

    public void visit(SaAppel node) throws Exception
    {
        defaultIn(node);
        if(node.getArguments() != null) node.getArguments().accept(this);
        defaultOut(node);
    }

    public void visit(SaExpAppel node) throws Exception
    {
        defaultIn(node);
        node.getVal().accept(this);
        defaultOut(node);
    }

    // EXP -> add EXP EXP
    public void visit(SaExpAdd node) throws Exception
    {
        defaultIn(node);
        node.getOp1().accept(this);
        node.getOp2().accept(this);
        defaultOut(node);
    }

    // EXP -> sub EXP EXP
    public void visit(SaExpSub node) throws Exception
    {
        defaultIn(node);
        node.getOp1().accept(this);
        node.getOp2().accept(this);
        defaultOut(node);
    }

    // EXP -> mult EXP EXP
    public void visit(SaExpMult node) throws Exception
    {
        defaultIn(node);
        node.getOp1().accept(this);
        node.getOp2().accept(this);
        defaultOut(node);
    }

    // EXP -> div EXP EXP
    public void visit(SaExpDiv node) throws Exception
    {
        defaultIn(node);
        node.getOp1().accept(this);
        node.getOp2().accept(this);
        defaultOut(node);
    }

    // EXP -> inf EXP EXP
    public void visit(SaExpInf node) throws Exception
    {
        defaultIn(node);
        node.getOp1().accept(this);
        node.getOp2().accept(this);
        defaultOut(node);
    }

    // EXP -> eq EXP EXP
    public void visit(SaExpEqual node) throws Exception
    {
        defaultIn(node);
        node.getOp1().accept(this);
        node.getOp2().accept(this);
        defaultOut(node);
    }

    // EXP -> and EXP EXP
    public void visit(SaExpAnd node) throws Exception
    {
        defaultIn(node);
        node.getOp1().accept(this);
        node.getOp2().accept(this);
        defaultOut(node);
    }


    // EXP -> or EXP EXP
    public void visit(SaExpOr node) throws Exception
    {
        defaultIn(node);
        node.getOp1().accept(this);
        node.getOp2().accept(this);
        defaultOut(node);
    }

    // EXP -> not EXP
    public void visit(SaExpNot node) throws Exception
    {
        defaultIn(node);
        node.getOp1().accept(this);
        defaultOut(node);
    }


    public void visit(SaExpLire node) throws Exception
    {
        defaultIn(node);
        defaultOut(node);
    }

    public void visit(SaInstBloc node) throws Exception
    {
        defaultIn(node);
        node.getVal().accept(this);
        defaultOut(node);
    }

    public void visit(SaInstSi node) throws Exception
    {
        defaultIn(node);
        node.getTest().accept(this);
        if (node.getAlors() != null)
            node.getAlors().accept(this);
        if(node.getSinon() != null) node.getSinon().accept(this);
        defaultOut(node);
    }

    // INST -> ret EXP
    public void visit(SaInstRetour node) throws Exception
    {
        defaultIn(node);
        node.getVal().accept(this);
        defaultOut(node);
    }


    public void visit(SaLExp node) throws Exception
    {
        defaultIn(node);
        node.getTete().accept(this);
        if(node.getQueue() != null)
            node.getQueue().accept(this);
        defaultOut(node);
    }
    public void visit(SaVarIndicee node) throws Exception
    {
        defaultIn(node);
        node.getIndice().accept(this);
        defaultOut(node);
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
