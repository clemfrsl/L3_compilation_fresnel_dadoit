package c3a;
import java.util.*;
import ts.*;
import sa.*;

public class Sa2c3a extends SaDepthFirstVisitor <C3aOperand> {
    private C3a c3a;
    int indentation;
    public C3a getC3a(){return this.c3a;}
    
    public Sa2c3a(SaNode root, Ts tableGlobale){
	c3a = new C3a();
	C3aTemp result = c3a.newTemp();
	C3aFunction fct = new C3aFunction(tableGlobale.getFct("main"));
	c3a.ajouteInst(new C3aInstCall(fct, result, ""));
	c3a.ajouteInst(new C3aInstStop(result, ""));
	
	indentation = 0;
	try{
	    root.accept(this);
	}
	catch(Exception e){}
    }
    public void defaultIn(SaNode node) {
        //for(int i = 0; i < indentation; i++){System.out.print(" ");}
        //indentation++;
        //System.out.println("<" + node.getClass().getSimpleName() + ">");
    }

    public void defaultOut(SaNode node) {
        //indentation--;
        //	for(int i = 0; i < indentation; i++){System.out.print(" ");}
        //	System.out.println("</" + node.getClass().getSimpleName() + ">");
    }





    public C3aOperand visit(SaProg node) throws Exception
    {
        defaultIn(node);
        C3aOperand op1 = node.getVariables().accept(this);
        C3aOperand op2 = node.getFonctions().accept(this);
        defaultOut(node);
        return null;
    }

    //todo
    // DEC -> var id taille
    public C3aOperand visit(SaDecTab node) throws Exception{
        defaultIn(node);
        defaultOut(node);
        return null;
    }

    public C3aOperand visit(SaExp node) throws Exception
    {
        defaultIn(node);
        defaultOut(node);
        return null;
    }

    // EXP -> entier
    public C3aOperand visit(SaExpInt node) throws Exception
    {
        defaultIn(node);
        defaultOut(node);
        return null;
    }

    // EXP -> vrai
    public C3aOperand visit(SaExpVrai node) throws Exception
    {
        defaultIn(node);
        defaultOut(node);
        return null;
    }

    // EXP -> faux
    public C3aOperand visit(SaExpFaux node) throws Exception
    {
        defaultIn(node);
        defaultOut(node);
        return null;
    }

    public C3aOperand visit(SaExpVar node) throws Exception
    {
        defaultIn(node);
        node.getVar().accept(this);
        defaultOut(node);
        return null;
    }

    public C3aOperand visit(SaInstEcriture node) throws Exception
    {
        defaultIn(node);
        C3aOperand op1 = node.getArg().accept(this);
        c3a.ajouteInst(new C3aInstWrite(op1, ""));
        defaultOut(node);
        return null;
    }

    public C3aOperand visit(SaInstTantQue node) throws Exception
    {
        defaultIn(node);
        node.getTest().accept(this);
        if (node.getFaire() != null)
            node.getFaire().accept(this);
        defaultOut(node);
        return null;
    }
    public C3aOperand visit(SaLInst node) throws Exception
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
    public C3aOperand visit(SaDecFonc node) throws Exception
    {
        defaultIn(node);
        if(node.getParametres() != null) node.getParametres().accept(this);
        if(node.getVariable() != null) node.getVariable().accept(this);
        if(node.getCorps() != null) node.getCorps().accept(this);
        defaultOut(node);
        return null;
    }

    // DEC -> var id
    public C3aOperand visit(SaDecVar node) throws Exception
    {
        defaultIn(node);
        defaultOut(node);
        return null;
    }

    public C3aOperand visit(SaInstAffect node) throws Exception
    {
        defaultIn(node);
        node.getLhs().accept(this);
        C3aOperand op1 = node.getRhs().accept(this);
        C3aOperand result = c3a.newTemp();
        c3a.ajouteInst(new C3aInstAffect(op1, result, ""));
        defaultOut(node);
        return null;
    }

    // LDEC -> DEC LDEC
    // LDEC -> null
    /*    public C3aOperand visit(SaLDec node) throws Exception
    {
	defaultIn(node);
	node.getTete().accept(this);
	if(node.getQueue() != null) node.getQueue().accept(this);
	defaultOut(node);
	return null;
	}*/

    public C3aOperand visit(SaLDecVar node) throws Exception
    {
        defaultIn(node);
        node.getTete().accept(this);
        if(node.getQueue() != null) node.getQueue().accept(this);
        defaultOut(node);
        return null;
    }

    public C3aOperand visit(SaLDecFonc node) throws Exception
    {
        defaultIn(node);
        node.getTete().accept(this);
        if(node.getQueue() != null) node.getQueue().accept(this);
        defaultOut(node);
        return null;
    }

    public C3aOperand visit(SaVarSimple node) throws Exception
    {
        defaultIn(node);
        defaultOut(node);
        return null;
    }

    public C3aOperand visit(SaAppel node) throws Exception
    {
        defaultIn(node);
        if(node.getArguments() != null) node.getArguments().accept(this);
        defaultOut(node);
        return null;
    }

    public C3aOperand visit(SaExpAppel node) throws Exception
    {
        defaultIn(node);
        node.getVal().accept(this);
        defaultOut(node);
        return null;
    }

    // EXP -> add EXP EXP
    public C3aOperand visit(SaExpAdd node) throws Exception {
        defaultIn(node);
        C3aOperand op1 = node.getOp1().accept(this);
        C3aOperand op2 = node.getOp2().accept(this);
        C3aOperand result = c3a.newTemp();
        c3a.ajouteInst(new C3aInstAdd(op1, op2, result, ""));
        defaultOut(node);
        return result;
    }

    // EXP -> sub EXP EXP
    public C3aOperand visit(SaExpSub node) throws Exception
    {
        defaultIn(node);
        C3aOperand op1 = node.getOp1().accept(this);
        C3aOperand op2 = node.getOp2().accept(this);
        C3aOperand result = c3a.newTemp();
        c3a.ajouteInst(new C3aInstSub(op1, op2, result, ""));
        defaultOut(node);
        return result;
    }

    // EXP -> mult EXP EXP
    public C3aOperand visit(SaExpMult node) throws Exception
    {
        defaultIn(node);
        C3aOperand op1 = node.getOp1().accept(this);
        C3aOperand op2 = node.getOp2().accept(this);
        C3aOperand result = c3a.newTemp();
        c3a.ajouteInst(new C3aInstMult(op1, op2, result, ""));
        defaultOut(node);
        return result;
    }

    // EXP -> div EXP EXP
    public C3aOperand visit(SaExpDiv node) throws Exception
    {
        defaultIn(node);
        C3aOperand op1 = node.getOp1().accept(this);
        C3aOperand op2 = node.getOp2().accept(this);
        C3aOperand result = c3a.newTemp();
        c3a.ajouteInst(new C3aInstDiv(op1, op2, result, ""));
        defaultOut(node);
        return result;
    }

    // EXP -> inf EXP EXP
    //todo
    public C3aOperand visit(SaExpInf node) throws Exception
    {
        defaultIn(node);
        C3aOperand op1 = node.getOp1().accept(this);
        C3aOperand op2 = node.getOp2().accept(this);
        C3aOperand result = c3a.newAutoLabel();
        c3a.ajouteInst(new C3aInstJumpIfLess(op1, op2, result, ""));
        defaultOut(node);
        return result;
    }

    // EXP -> eq EXP EXP
    public C3aOperand visit(SaExpEqual node) throws Exception
    {
        defaultIn(node);
        C3aOperand op1 = node.getOp1().accept(this);
        C3aOperand op2 = node.getOp2().accept(this);
        C3aOperand result = c3a.newAutoLabel();
        c3a.ajouteInst(new C3aInstJumpIfEqual(op1, op2, result, ""));
        defaultOut(node);
        return result;
    }

    //todo
    // EXP -> and EXP EXP
    public C3aOperand visit(SaExpAnd node) throws Exception
    {
        defaultIn(node);
        C3aOperand op1 = node.getOp1().accept(this);
        C3aOperand op2 = node.getOp2().accept(this);
        C3aOperand result = c3a.newTemp();
        c3a.ajouteInst(new C3aInstAdd(op1, op2, result, ""));
        defaultOut(node);
        return null;
    }


    // EXP -> or EXP EXP
    public C3aOperand visit(SaExpOr node) throws Exception
    {
        defaultIn(node);
        node.getOp1().accept(this);
        node.getOp2().accept(this);
        defaultOut(node);
        return null;
    }

    // EXP -> not EXP
    public C3aOperand visit(SaExpNot node) throws Exception
    {
        defaultIn(node);
        node.getOp1().accept(this);
        defaultOut(node);
        return null;
    }


    public C3aOperand visit(SaExpLire node) throws Exception
    {
        defaultIn(node);
        C3aOperand result = c3a.newTemp();
        c3a.ajouteInst(new C3aInstRead(result, ""));
        defaultOut(node);
        return null;
    }

    public C3aOperand visit(SaInstBloc node) throws Exception
    {
        defaultIn(node);
        node.getVal().accept(this);
        defaultOut(node);
        return null;
    }

    public C3aOperand visit(SaInstSi node) throws Exception
    {
        defaultIn(node);
        C3aOperand result = null;
        node.getTest().accept(this);
        if (node.getAlors() != null)
            node.getAlors().accept(this);
        if(node.getSinon() != null)
            node.getSinon().accept(this);
        result = c3a.newAutoLabel();
        c3a.ajouteInst(new C3aInstJump(result, ""));
        defaultOut(node);
        return null;
    }

    // INST -> ret EXP
    public C3aOperand visit(SaInstRetour node) throws Exception
    {
        defaultIn(node);
        C3aOperand op1 = node.getVal().accept(this);
        c3a.ajouteInst(new C3aInstReturn(op1, ""));
        node.getVal().accept(this);
        defaultOut(node);
        return null;
    }


    public C3aOperand visit(SaLExp node) throws Exception
    {
        defaultIn(node);
        node.getTete().accept(this);
        if(node.getQueue() != null)
            node.getQueue().accept(this);
        defaultOut(node);
        return null;
    }

    public C3aOperand visit(SaVarIndicee node) throws Exception
    {
        defaultIn(node);
        node.getIndice().accept(this);
        defaultOut(node);
        return null;
    }

}
