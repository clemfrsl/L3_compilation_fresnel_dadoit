import sc.analysis.*;
import sc.node.*;
import sa.*;
import util.Type;

public class Sc2sa extends DepthFirstAdapter
{
    //pas fini :
    //to, inst, e6 et fin
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

    //programme = ldv ldf
    @Override
    public void caseAProgramme(AProgramme node)
    {
        SaLDecVar variables = null;
        SaLDecFonc fonctions = null;
        inAProgramme(node);
        if(node.getLdv() != null)
        {
            node.getLdv().apply(this);
            variables = (SaLDecVar) this.returnValue;
        }
        if(node.getLdf() != null)
        {
            node.getLdf().apply(this);
            fonctions = (SaLDecFonc) this.returnValue;
        }
        this.returnValue = new SaProg(variables, fonctions);
        outAProgramme(node);
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

    //dv = {declarationvariableidtableau} tv identif crochetgauche nombre crochetdroit;
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
        SaDecFonc op1 = null;
        SaLDecFonc op2 = null;
        inAListedeclarationfonctionLdf(node);
        if(node.getDf() != null)
        {
            node.getDf().apply(this);
            op1 = (SaDecFonc) this.returnValue;
        }
        if(node.getLdf() != null)
        {
            node.getLdf().apply(this);
            op2 = (SaLDecFonc) this.returnValue;
        }
        this.returnValue = new SaLDecFonc(op1, op2);
        outAListedeclarationfonctionLdf(node);
    }

    //tv = {typebool} boolean
    @Override
    public void caseATypeboolTv(ATypeboolTv node)
    {
        inATypeboolTv(node);
        if(node.getBoolean() != null)
        {
            node.getBoolean().apply(this);
        }
        this.returnType = Type.BOOL;
        outATypeboolTv(node);
    }

    //tv = {typeentier} entier;
    @Override
    public void caseATypeentierTv(ATypeentierTv node)
    {
        inATypeentierTv(node);
        if(node.getEntier() != null)
        {
            node.getEntier().apply(this);
        }
        this.returnType = Type.ENTIER;
        outATypeentierTv(node);
    }

    //df = to identif parenthesegauche [premier]:ldv parenthesedroite [second]:ldv bi;
    @Override
    public void caseADf(ADf node)
    {
        Type type = null;
        SaLDecVar parametres = null;
        SaLDecVar variables = null;
        SaInst corps = null;
        inADf(node);
        if(node.getTo() != null)
        {
            node.getTo().apply(this);
            type = this.returnType;
        }
        if(node.getPremier() != null)
        {
            node.getPremier().apply(this);
            parametres = (SaLDecVar) this.returnValue;
        }
        if(node.getSecond() != null)
        {
            node.getSecond().apply(this);
            variables = (SaLDecVar) this.returnValue;
        }
        if(node.getBi() != null)
        {
            node.getBi().apply(this);
            corps = (SaInst) this.returnValue;
        }
        this.returnValue = new SaDecFonc(node.getIdentif().getText(), type, parametres, variables, corps);
        outADf(node);
    }

    //to = {typeoptionel} tv
    /*@Override
    public void caseATypeoptionelTo(ATypeoptionelTo node)
    {
        inATypeoptionelTo(node);
        if(node.getTv() != null)
        {
            node.getTv().apply(this);
        }
        outATypeoptionelTo(node);
    }*/

    //bi = accoladegauche li accoladedroite;
    @Override
    public void caseABi(ABi node)
    {
        SaLInst op = null;
        inABi(node);
        if(node.getLi() != null)
        {
            node.getLi().apply(this);
            op = (SaLInst) this.returnValue;
        }
        this.returnValue = new SaInstBloc(op);
        outABi(node);
    }

    //li = {listeinstruction} inst li
    @Override
    public void caseAListeinstructionLi(AListeinstructionLi node)
    {
        SaInst op1 = null;
        SaLInst op2 = null;
        inAListeinstructionLi(node);
        if(node.getInst() != null)
        {
            node.getInst().apply(this);
            op1 = (SaInst) this.returnValue;
        }
        if(node.getLi() != null)
        {
            node.getLi().apply(this);
            op2 = (SaLInst) this.returnValue;
        }
        this.returnValue = new SaLInst(op1, op2);
        outAListeinstructionLi(node);
    }

    //inst = {assignation} var egal exp pointvirgule
    public void caseAAssignationInst(AAssignationInst node)
    {
        SaVar op1 = null;
        SaExp op2 = null;
        inAAssignationInst(node);
        if(node.getVar() != null)
        {
            node.getVar().apply(this);
            op1 = (SaVar) this.returnValue;
        }
        if(node.getExp() != null)
        {
            node.getExp().apply(this);
            op2 = (SaExp) this.returnValue;
        }
        this.returnValue = new SaInstAffect(op1, op2);
        outAAssignationInst(node);
    }

    //inst = {boucletantque} tantque exp faire bi
    @Override
    public void caseABoucletantqueInst(ABoucletantqueInst node)
    {
        SaExp test = null;
        SaInst faire = null;
        inABoucletantqueInst(node);
        if(node.getExp() != null)
        {
            node.getExp().apply(this);
            test = (SaExp) this.returnValue;
        }
        if(node.getBi() != null)
        {
            node.getBi().apply(this);
            faire = (SaInst) this.returnValue;
        }
        this.returnValue = new SaInstTantQue(test, faire);
        outABoucletantqueInst(node);
    }

    //inst = {sialors} si exp alors bi
    @Override
    public void caseASialorsInst(ASialorsInst node)
    {
        SaExp test = null;
        SaInst alors = null;
        inASialorsInst(node);
        if(node.getExp() != null)
        {
            node.getExp().apply(this);
            test = (SaExp) this.returnValue;
        }
        if(node.getBi() != null)
        {
            node.getBi().apply(this);
            alors = (SaInst) this.returnValue;
        }
        this.returnValue = new SaInstSi(test, alors, null);
        outASialorsInst(node);
    }

    //inst = {sialorssinon} si exp alors [premier]:bi sinon [second]:bi
    @Override
    public void caseASialorssinonInst(ASialorssinonInst node)
    {
        SaExp test = null;
        SaInst alors = null;
        SaInst sinon = null;
        inASialorssinonInst(node);
        if(node.getExp() != null)
        {
            node.getExp().apply(this);
            test = (SaExp) this.returnValue;
        }
        if(node.getPremier() != null)
        {
            node.getPremier().apply(this);
            alors = (SaInst) this.returnValue;
        }
        if(node.getSecond() != null)
        {
            node.getSecond().apply(this);
            sinon = (SaInst) this.returnValue;
        }
        this.returnValue = new SaInstSi(test, alors, sinon);
        outASialorssinonInst(node);
    }

    //inst = {retour} retour exp pointvirgule
    @Override
    public void caseARetourInst(ARetourInst node)
    {
        SaExp op = null;
        inARetourInst(node);
        if(node.getExp() != null)
        {
            node.getExp().apply(this);
            op = (SaExp) this.returnValue;
        }
        this.returnValue = new SaInstRetour(op);
        outARetourInst(node);
    }

    //inst = {fonctionecrire} ecrire parenthesegauche exp parenthesedroite pointvirgule
    @Override
    public void caseAFonctionecrireInst(AFonctionecrireInst node)
    {
        SaExp op = null;
        inAFonctionecrireInst(node);
        if(node.getExp() != null)
        {
            node.getExp().apply(this);
            op = (SaExp) this.returnValue;
        }
        this.returnValue = new SaInstEcriture(op);
        outAFonctionecrireInst(node);
    }

    //inst = {appelfonction} identif parenthesegauche lexp parenthesedroite pointvirgule
    //SaInstBloc(SaLInst val)
    //on demande un liste d'inst mais on a liste d'exp - fait mais pas sur donc
    /*@Override
    public void caseAAppelfonctionInst(AAppelfonctionInst node)
    {
        SaLInst val = null;
        inAAppelfonctionInst(node);
        if(node.getLexp() != null)
        {
            node.getLexp().apply(this);
            val = (SaLInst) this.returnValue;
        }
        this.returnValue = new SaInstBloc(val);
        outAAppelfonctionInst(node);
    }*/

    //lexp = {listeexpr} exp lexpbis
    @Override
    public void caseAListeexprLexp(AListeexprLexp node)
    {
        SaExp op1 = null;
        SaLExp op2 = null;
        inAListeexprLexp(node);
        if(node.getExp() != null)
        {
            node.getExp().apply(this);
            op1 = (SaExp) this.returnValue;
        }
        if(node.getLexpbis() != null)
        {
            node.getLexpbis().apply(this);
            op2 = (SaLExp) this.returnValue;
        }
        this.returnValue = new SaLExp(op1, op2);
        outAListeexprLexp(node);
    }

    //lexpbis = {listeexprbis} virgule exp lexpbis
    @Override
    public void caseAListeexprbisLexpbis(AListeexprbisLexpbis node)
    {
        SaExp op1 = null;
        SaLExp op2 = null;
        inAListeexprbisLexpbis(node);
        if(node.getExp() != null)
        {
            node.getExp().apply(this);
            op1 = (SaExp) this.returnValue;
        }
        if(node.getLexpbis() != null)
        {
            node.getLexpbis().apply(this);
            op2 = (SaLExp) this.returnValue;
        }
        this.returnValue = new SaLExp(op1, op2);
        outAListeexprbisLexpbis(node);
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
        this.returnValue = new SaExpOr(op1, op2);
        outAOuExp(node);
    }

    //exp = {pasou} e1
    @Override
    public void caseAPasouExp(APasouExp node)
    {
        SaExp op = null;
        inAPasouExp(node);
        if(node.getE1() != null)
        {
            node.getE1().apply(this);
            op = (SaExp) this.returnValue;
        }
        this.returnValue = op;
        outAPasouExp(node);
    }

    //e1 = {et} e1 et e2
    @Override
    public void caseAEtE1(AEtE1 node)
    {
        SaExp op1 = null;
        SaExp op2 = null;
        inAEtE1(node);
        if(node.getE1() != null)
        {
            node.getE1().apply(this);
            op1 = (SaExp) this.returnValue;
        }
        if(node.getE2() != null)
        {
            node.getE2().apply(this);
            op2 = (SaExp) this.returnValue;
        }
        this.returnValue = new SaExpAnd(op1, op2);
        outAEtE1(node);
    }

    //e1 = {paset} e2
    @Override
    public void caseAPasetE1(APasetE1 node)
    {
        SaExp op = null;
        inAPasetE1(node);
        if(node.getE2() != null)
        {
            node.getE2().apply(this);
            op = (SaExp) this.returnValue;
        }
        this.returnValue = op;
        outAPasetE1(node);
    }

    //e2 = {egal} e2 egal e3
    @Override
    public void caseAEgalE2(AEgalE2 node)
    {
        SaExp op1 = null;
        SaExp op2 = null;
        inAEgalE2(node);
        if(node.getE2() != null)
        {
            node.getE2().apply(this);
            op1 = (SaExp) this.returnValue;
        }
        if(node.getE3() != null)
        {
            node.getE3().apply(this);
            op2 = (SaExp) this.returnValue;
        }
        this.returnValue = new SaExpEqual(op1, op2);
        outAEgalE2(node);
    }

    //e2 = {inf} e2 inf e3
    @Override
    public void caseAInfE2(AInfE2 node)
    {
        SaExp op1 = null;
        SaExp op2 = null;
        inAInfE2(node);
        if(node.getE2() != null)
        {
            node.getE2().apply(this);
            op1 = (SaExp) this.returnValue;
        }
        if(node.getE3() != null)
        {
            node.getE3().apply(this);
            op2 = (SaExp) this.returnValue;
        }
        this.returnValue = new SaExpInf(op1, op2);
        outAInfE2(node);
    }

    //e2 ={pasegalinf} e3
    @Override
    public void caseAPasegalinfE2(APasegalinfE2 node)
    {
        SaExp op = null;
        inAPasegalinfE2(node);
        if(node.getE3() != null)
        {
            node.getE3().apply(this);
            op = (SaExp) this.returnValue;
        }
        this.returnValue = op;
        outAPasegalinfE2(node);
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

    //e3 = {moins} e3 moins e4
    @Override
    public void caseAMoinsE3(AMoinsE3 node)
    {
        SaExp op1 = null;
        SaExp op2 = null;
        inAMoinsE3(node);
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
        this.returnValue = new SaExpSub(op1, op2);
        outAMoinsE3(node);
    }

    //e3 = {pasplusmoins} e4
    @Override
    public void caseAPasplusmoinsE3(APasplusmoinsE3 node)
    {
        SaExp op = null;
        inAPasplusmoinsE3(node);
        if(node.getE4() != null)
        {
            node.getE4().apply(this);
            op = (SaExp) this.returnValue;
        }
        this.returnValue = op;
        outAPasplusmoinsE3(node);
    }

    //e4 = {mul} e4 mul e5
    @Override
    public void caseAMulE4(AMulE4 node)
    {
        SaExp op1 = null;
        SaExp op2 = null;
        inAMulE4(node);
        if(node.getE4() != null)
        {
            node.getE4().apply(this);
            op1 = (SaExp) this.returnValue;
        }
        if(node.getE5() != null)
        {
            node.getE5().apply(this);
            op2 = (SaExp) this.returnValue;
        }
        this.returnValue = new SaExpMult(op1, op2);
        outAMulE4(node);
    }

    //e4 = {div} e4 div e5
    @Override
    public void caseADivE4(ADivE4 node)
    {
        SaExp op1 = null;
        SaExp op2 = null;
        inADivE4(node);
        if(node.getE4() != null)
        {
            node.getE4().apply(this);
            op1 = (SaExp) this.returnValue;
        }
        if(node.getE5() != null)
        {
            node.getE5().apply(this);
            op2 = (SaExp) this.returnValue;
        }
        this.returnValue = new SaExpDiv(op1, op2);
        outADivE4(node);
    }

    //e4 = {pasmuldiv} e5
    @Override
    public void caseAPasmuldivE4(APasmuldivE4 node)
    {
        SaExp op = null;
        inAPasmuldivE4(node);
        if(node.getE5() != null)
        {
            node.getE5().apply(this);
            op = (SaExp) this.returnValue;
        }
        this.returnValue = op;
        outAPasmuldivE4(node);
    }

    //e5 = {negation} non e5
    @Override
    public void caseANegationE5(ANegationE5 node)
    {
        SaExp op = null;
        inANegationE5(node);
        if(node.getE5() != null)
        {
            node.getE5().apply(this);
            op = (SaExp) this.returnValue;
        }
        this.returnValue = new SaExpNot(op);
        outANegationE5(node);
    }

    //e5 = {pasnegation} e6
    @Override
    public void caseAPasnegationE5(APasnegationE5 node)
    {
        SaExp op = null;
        inAPasnegationE5(node);
        if(node.getE6() != null)
        {
            node.getE6().apply(this);
            op = (SaExp) this.returnValue;
        }
        this.returnValue = op;
        outAPasnegationE5(node);
    }

    //e6 = {eboucleexpr} parenthesegauche exp parenthesedroite
    @Override
    public void caseAEboucleexprE6(AEboucleexprE6 node)
    {
        SaExp op = null;
        inAEboucleexprE6(node);
        if(node.getExp() != null)
        {
            node.getExp().apply(this);
            op = (SaExp) this.returnValue;
        }
        this.returnValue = op;
        outAEboucleexprE6(node);
    }

    //e6 = {evar} var
    //SaExpVar(SaVar var)
    @Override
    public void caseAEvarE6(AEvarE6 node)
    {
        SaVar op = null;
        inAEvarE6(node);
        if(node.getVar() != null)
        {
            node.getVar().apply(this);
            op = (SaVar) this.returnValue;
        }
        this.returnValue = new SaExpVar(op);
        outAEvarE6(node);
    }

    //e6 = {enombre} nombre
    @Override
    public void caseAEnombreE6(AEnombreE6 node)
    {
        inAEnombreE6(node);
        //todo: pas sur mais comm c'est terminal
        outAEnombreE6(node);
    }

    //e6 = {efonction} identif parenthesegauche lexp parenthesedroite
    @Override
    public void caseAEfonctionE6(AEfonctionE6 node)
    {
        SaAppel op = null;
        inAEfonctionE6(node);
        if(node.getLexp() != null)
        {
            node.getLexp().apply(this);
            op = (SaAppel) this.returnValue;
        }
        this.returnValue = new SaExpAppel(op);// todo pas sur
        outAEfonctionE6(node);
    }

    //e6 = {elire} lire parenthesegauche parenthesedroite
    @Override
    public void caseAElireE6(AElireE6 node)
    {
        inAElireE6(node);
        this.returnValue = new SaExpLire();
        outAElireE6(node);
    }

    //e6 = {evrai} vrai
    @Override
    public void caseAEvraiE6(AEvraiE6 node)
    {
        inAEvraiE6(node);
        this.returnValue = new SaExpVrai();
        outAEvraiE6(node);
    }

    //e6 = {efaux} faux
    @Override
    public void caseAEfauxE6(AEfauxE6 node)
    {
        inAEfauxE6(node);
        this.returnValue = new SaExpFaux();
        outAEfauxE6(node);
    }

    //var = {varidentif} identif
    @Override
    public void caseAVaridentifVar(AVaridentifVar node)
    {
        SaDecVar op = null;
        inAVaridentifVar(node);
        if(node.getIdentif() != null)
        {
            node.getIdentif().apply(this);
            op = (SaDecVar) this.returnValue;
        }
        this.returnValue = new SaVarSimple(op.getNom());
        outAVaridentifVar(node);
    }

    //var = {varfonction} identif crochetgauche exp crochetdroit
    @Override
    public void caseAVarfonctionVar(AVarfonctionVar node)
    {
        SaDecVar op1 = null;
        SaExp op2 = null;
        inAVarfonctionVar(node);
        if(node.getIdentif() != null)
        {
            node.getIdentif().apply(this);
            op1 = (SaDecVar) this.returnValue;
        }
        if(node.getExp() != null)
        {
            node.getExp().apply(this);
            op2 = (SaExp) this.returnValue;
        }
        this.returnValue = new SaVarIndicee(op1.getNom(), op2);
        outAVarfonctionVar(node);
    }

}
