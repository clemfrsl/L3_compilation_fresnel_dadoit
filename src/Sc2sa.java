import sc.analysis.*;
import sc.node.*;
import sa.*;
import util.Type;

public class Sc2sa extends DepthFirstAdapter
{
    private SaNode returnValue;
    private Type returnType;

    public void defaultIn(@SuppressWarnings("unused") Node node)
    {
	//System.out.println("<" + node.getClass().getSimpleName() + ">");
    }

    public void defaultOut(@SuppressWarnings("unused") Node node)
    {
	//System.out.println("</" + node.getClass().getSimpleName() + ">");
    }
    
    public SaNode getRoot()
    {
	return this.returnValue;
    }

    //ldv = {listedeclarationvariable} dv ldvbis
    @Override
    public void caseAListedeclarationvariableLdv(AListedeclarationvariableLdv node)
    {
        SaDecVar op1 = null;
        SaLDecVar op2 = null;
        inAListedeclarationvariableLdv(node);
        if(node.getDv() != null)
        {
            node.getDv().apply(this);
            op1 = (SaDecVar) this.returnValue;
        }
        if(node.getLdvbis() != null)
        {
            node.getLdvbis().apply(this);
            op2 = (SaLDecVar) this.returnValue;
        }
        this.returnValue = new SaLDecVar(op1, op2);
        outAListedeclarationvariableLdv(node);
    }

    //ldvbis = {listedeclarationvariablebis} virgule dv ldvbis
    @Override
    public void caseAListedeclarationvariablebisLdvbis(AListedeclarationvariablebisLdvbis node)
    {
        SaDecVar op1 = null;
        SaLDecVar op2 = null;
        inAListedeclarationvariablebisLdvbis(node);
        if(node.getDv() != null)
        {
            node.getDv().apply(this);
            op1 = (SaDecVar) this.returnValue;
        }
        if(node.getLdvbis() != null)
        {
            node.getLdvbis().apply(this);
            op2 = (SaLDecVar) this.returnValue;
        }
        this.returnValue = new SaLDecVar(op1, op2);
        outAListedeclarationvariablebisLdvbis(node);
    }

    //dv = {declarationvariableid} tv identif
    @Override
    public void caseADeclarationvariableidDv(ADeclarationvariableidDv node)
    {
        inADeclarationvariableidDv(node);
        if(node.getTv() != null)
        {
            node.getTv().apply(this);
        }
        this.returnValue = new SaDecVarSimple(node.getIdentif().getText(), this.returnType);
        outADeclarationvariableidDv(node);
    }

    //{declarationvariableidtableau} tv identif crochetgauche nombre crochetdroit;
    @Override
    public void caseADeclarationvariableidtableauDv(ADeclarationvariableidtableauDv node)
    {
        inADeclarationvariableidtableauDv(node);
        if(node.getTv() != null)
        {
            node.getTv().apply(this);
        }
        int nombre = Integer.parseInt(node.getNombre().getText());
        this.returnValue = new SaDecTab(node.getIdentif().getText(), this.returnType, nombre);
        outADeclarationvariableidtableauDv(node);
    }

    //ldf = {listedeclarationfonction} df ldf
    @Override
    public void caseAListedeclarationfonctionLdf(AListedeclarationfonctionLdf node)
    {
        SaExp op1 = null;
        SaExp op2 = null;
        inAListedeclarationfonctionLdf(node);
        if(node.getDf() != null)
        {
            node.getDf().apply(this);
            op1 = (SaExp) this.returnValue;
        }
        if(node.getLdf() != null)
        {
            node.getLdf().apply(this);
            op2 = (SaExp) this.returnValue;
        }
        this.returnValue = new SaExpAdd(op1, op2);
        outAListedeclarationfonctionLdf(node);
    }



    //exp = {ou} exp ou e1
    @Override
    public void caseAOuExp(AOuExp node)
    {
        SaExp op1 = null;
        SaExp op2 = null;
        inAOuExp(node);
        if(node.getExp() != null)
        {
            node.getExp().apply(this);
            op1 = (SaExp) this.returnValue;
        }
        if(node.getE1() != null)
        {
            node.getE1().apply(this);
            op2 = (SaExp) this.returnValue;
        }
        this.returnValue = new SaExpAdd(op1, op2);
        outAOuExp(node);
    }

    //exp = {pasou} e1
    @Override
    public void caseAPasouExp(APasouExp node)
    {
        SaExp op1 = null;
        inAPasouExp(node);
        if(node.getE1() != null)
        {
            node.getE1().apply(this);
            op1 = (SaExp) this.returnValue;
        }
        this.returnValue = op1;
        outAPasouExp(node);
    }

    //e3 = {plus} e3 plus e4
    @Override
    public void caseAPlusE3(APlusE3 node)
    {
        SaExp op1 = null;
        SaExp op2 = null;
        inAPlusE3(node);
        if(node.getE3() != null)
        {
            node.getE3().apply(this);
            op1 = (SaExp) this.returnValue;
        }

        if(node.getE4() != null)
        {
            node.getE4().apply(this);
            op2 = (SaExp) this.returnValue;
        }
        this.returnValue = new SaExpAdd(op1, op2);
        outAPlusE3(node);
    }

    @Override
    public void caseATypeboolTv(ATypeboolTv node)
    {
        inATypeboolTv(node);
        if(node.getBoolean() != null)
        {
            node.getBoolean().apply(this);
        }
        returnType = Type.BOOL;
        outATypeboolTv(node);
    }


}
