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
        SaDecVar tete = null;
        SaLDecVar queue = null;
        inAListedeclarationvariableLdv(node);
        if(node.getDv() != null)
        {
            node.getDv().apply(this);
            tete = (SaDecVar) this.returnValue;
        }
        if(node.getLdvbis() != null)
        {
            node.getLdvbis().apply(this);
            queue = (SaLDecVar) this.returnValue;
        }
        this.returnValue = new SaLDecVar(tete, queue);
        outAListedeclarationvariableLdv(node);
    }

    //ldv epsilon
    @Override
    public void caseALdv(ALdv node)
    {
        inALdv(node);
        this.returnValue = null;
        outALdv(node);
    }

    //ldvbis = {listedeclarationvariablebis} virgule dv ldvbis
    @Override
    public void caseAListedeclarationvariablebisLdvbis(AListedeclarationvariablebisLdvbis node)
    {
        SaDecVar tete = null;
        SaLDecVar queue = null;
        inAListedeclarationvariablebisLdvbis(node);
        if(node.getDv() != null)
        {
            node.getDv().apply(this);
            tete = (SaDecVar) this.returnValue;
        }
        if(node.getLdvbis() != null)
        {
            node.getLdvbis().apply(this);
            queue = (SaLDecVar) this.returnValue;
        }
        this.returnValue = new SaLDecVar(tete, queue);
        outAListedeclarationvariablebisLdvbis(node);
    }

    //ldvbis epsilon
    @Override
    public void caseALdvbis(ALdvbis node)
    {
        inALdvbis(node);
        this.returnValue = null;
        outALdvbis(node);
    }

    //dv = {declarationvariableid} tv identif
    @Override
    public void caseADeclarationvariableidDv(ADeclarationvariableidDv node)
    {
        String id = null;
        Type type = null;
        inADeclarationvariableidDv(node);
        if(node.getTv() != null)
        {
            node.getTv().apply(this);
            type = this.returnType;
        }
        if(node.getIdentif() != null)
        {
            node.getIdentif().apply(this);
            id = node.getIdentif().getText();

        }
        this.returnValue = new SaDecVarSimple(id, type);
        outADeclarationvariableidDv(node);
    }

    //dv = {declarationvariableidtableau} tv identif crochetgauche nombre crochetdroit;
    @Override
    public void caseADeclarationvariableidtableauDv(ADeclarationvariableidtableauDv node)
    {
        String id = null;
        inADeclarationvariableidtableauDv(node);
        if(node.getTv() != null)
        {
            node.getTv().apply(this);
        }
        if(node.getIdentif() != null)
        {
            node.getIdentif().apply(this);
            id = node.getIdentif().getText();
        }
        if(node.getNombre() != null)
        {
            node.getNombre().apply(this);
        }
        this.returnValue = new SaDecTab(id, this.returnType, Integer.parseInt(node.getNombre().getText()));
        outADeclarationvariableidtableauDv(node);
    }

    //ldf = {listedeclarationfonction} df ldf
    @Override
    public void caseAListedeclarationfonctionLdf(AListedeclarationfonctionLdf node)
    {
        SaDecFonc tete = null;
        SaLDecFonc queue = null;
        inAListedeclarationfonctionLdf(node);
        if(node.getDf() != null)
        {
            node.getDf().apply(this);
            tete = (SaDecFonc) this.returnValue;
        }
        if(node.getLdf() != null)
        {
            node.getLdf().apply(this);
            queue = (SaLDecFonc) this.returnValue;
        }
        this.returnValue = new SaLDecFonc(tete, queue);
        outAListedeclarationfonctionLdf(node);
    }

    //ldf epsilon
    @Override
    public void caseALdf(ALdf node)
    {
        inALdf(node);
        this.returnValue = null;
        outALdf(node);
    }

    //tv = {typebool} boolean
    @Override
    public void caseATypeboolTv(ATypeboolTv node)
    {
        inATypeboolTv(node);
        this.returnType = Type.BOOL;
        outATypeboolTv(node);
    }

    //tv = {typeentier} entier;
    @Override
    public void caseATypeentierTv(ATypeentierTv node)
    {
        inATypeentierTv(node);
        this.returnType = Type.ENTIER;
        outATypeentierTv(node);
    }

    //df = to identif parenthesegauche [premier]:ldv parenthesedroite [second]:ldv bi;
    @Override
    public void caseADf(ADf node)
    {
        SaLDecVar parametres = null;
        SaLDecVar variables = null;
        SaInstBloc corps = null;
        inADf(node);
        if(node.getTo() != null)
        {
            node.getTo().apply(this);
        }
        if(node.getIdentif() != null)
        {
            node.getIdentif().apply(this);
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
            corps = (SaInstBloc) this.returnValue; //inst pour un bloc d'instruction //todo
        }
        this.returnValue = new SaDecFonc(node.getIdentif().getText(), this.returnType, parametres, variables, corps);
        outADf(node);
    }

    //to = {typeoptionel} : override pas nécessaire
    //to epsilon
    @Override
    public void caseATo(ATo node)
    {
        inATo(node);
        this.returnType = Type.NUL;
        outATo(node);
    }

    //bi = accoladegauche li accoladedroite;
    @Override
    public void caseABi(ABi node)
    {
        SaLInst val = null;
        inABi(node);
        if(node.getLi() != null)
        {
            node.getLi().apply(this);
            val = (SaLInst) this.returnValue;
        }
        this.returnValue = new SaInstBloc(val);
        outABi(node);
    }

    //li = {listeinstruction} inst li
    @Override
    public void caseAListeinstructionLi(AListeinstructionLi node)
    {
        SaInst tete = null;
        SaLInst queue = null;
        inAListeinstructionLi(node);
        if(node.getInst() != null)
        {
            node.getInst().apply(this);
            tete = (SaInst) this.returnValue;
        }
        if(node.getLi() != null)
        {
            node.getLi().apply(this);
            queue = (SaLInst) this.returnValue;
        }
        this.returnValue = new SaLInst(tete, queue);
        outAListeinstructionLi(node);
    }

    //li epsilon
    @Override
    public void caseALi(ALi node)
    {
        inALi(node);
        returnValue = null;
        outALi(node);
    }

    //inst = {assignation} var egal exp pointvirgule
    public void caseAAssignationInst(AAssignationInst node)
    {
        SaVar left = null;
        SaExp right = null;
        inAAssignationInst(node);
        if(node.getVar() != null)
        {
            node.getVar().apply(this);
            left = (SaVar) this.returnValue;
        }
        if(node.getExp() != null)
        {
            node.getExp().apply(this);
            right = (SaExp) this.returnValue;
        }
        this.returnValue = new SaInstAffect(left, right);
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
            faire = (SaInst) this.returnValue; //inst pour un bloc d'instruction //todo
        }
        this.returnValue = new SaInstTantQue(test, faire);
        outABoucletantqueInst(node);
    }

    //inst = {sialors} si exp alors bi
    @Override
    public void caseASialorsInst(ASialorsInst node)
    {
        SaExp test = null;
        SaInstBloc alors = null;
        inASialorsInst(node);
        if(node.getExp() != null)
        {
            node.getExp().apply(this);
            test = (SaExp) this.returnValue;
        }
        if(node.getBi() != null)
        {
            node.getBi().apply(this);
            alors = (SaInstBloc) this.returnValue; //inst pour un bloc d'instruction //todo
        }
        this.returnValue = new SaInstSi(test, alors, null);
        outASialorsInst(node);
    }

    //inst = {sialorssinon} si exp alors [premier]:bi sinon [second]:bi
    @Override
    public void caseASialorssinonInst(ASialorssinonInst node)
    {
        SaExp test = null;
        SaInstBloc alors = null;
        SaInstBloc sinon = null;
        inASialorssinonInst(node);
        if(node.getExp() != null)
        {
            node.getExp().apply(this);
            test = (SaExp) this.returnValue;
        }
        if(node.getPremier() != null)
        {
            node.getPremier().apply(this);
            alors = (SaInstBloc) this.returnValue; //inst pour un bloc d'instruction //todo
        }
        if(node.getSecond() != null)
        {
            node.getSecond().apply(this);
            sinon = (SaInstBloc) this.returnValue; //inst pour un bloc d'instruction //todo
        }
        this.returnValue = new SaInstSi(test, alors, sinon);
        outASialorssinonInst(node);
    }

    //inst = {retour} retour exp pointvirgule
    @Override
    public void caseARetourInst(ARetourInst node)
    {
        SaExp val = null;
        inARetourInst(node);
        if(node.getExp() != null)
        {
            node.getExp().apply(this);
            val = (SaExp) this.returnValue;
        }
        this.returnValue = new SaInstRetour(val);
        outARetourInst(node);
    }

    //inst = {fonctionecrire} ecrire parenthesegauche exp parenthesedroite pointvirgule
    @Override
    public void caseAFonctionecrireInst(AFonctionecrireInst node)
    {
        SaExp val = null;
        inAFonctionecrireInst(node);
        if(node.getExp() != null)
        {
            node.getExp().apply(this);
            val = (SaExp) this.returnValue;
        }
        this.returnValue = new SaInstEcriture(val);
        outAFonctionecrireInst(node);
    }

    //inst = {appelfonction} identif parenthesegauche lexp parenthesedroite pointvirgule
    @Override
    public void caseAAppelfonctionInst(AAppelfonctionInst node)
    {
        SaLExp arguments = null;
        inAAppelfonctionInst(node);
        if(node.getLexp() != null)
        {
            node.getLexp().apply(this);
            arguments = (SaLExp) this.returnValue;
        }
        this.returnValue = new SaAppel(node.getIdentif().getText(), arguments);
        outAAppelfonctionInst(node);
    }

    //lexp = {listeexpr} exp lexpbis
    @Override
    public void caseAListeexprLexp(AListeexprLexp node)
    {
        SaExp tete = null;
        SaLExp queue = null;
        inAListeexprLexp(node);
        if(node.getExp() != null)
        {
            node.getExp().apply(this);
            tete = (SaExp) this.returnValue;
        }
        if(node.getLexpbis() != null)
        {
            node.getLexpbis().apply(this);
            queue = (SaLExp) this.returnValue;
        }
        this.returnValue = new SaLExp(tete, queue);
        outAListeexprLexp(node);
    }

    //lexp epsilon
    @Override
    public void caseALexp(ALexp node)
    {
        inALexp(node);
        this.returnValue = null;
        outALexp(node);
    }

    //lexpbis = {listeexprbis} virgule exp lexpbis
    @Override
    public void caseAListeexprbisLexpbis(AListeexprbisLexpbis node)
    {
        SaExp tete = null;
        SaLExp queue = null;
        inAListeexprbisLexpbis(node);
        if(node.getExp() != null)
        {
            node.getExp().apply(this);
            tete = (SaExp) this.returnValue;
        }
        if(node.getLexpbis() != null)
        {
            node.getLexpbis().apply(this);
            queue = (SaLExp) this.returnValue;
        }
        this.returnValue = new SaLExp(tete, queue);
        outAListeexprbisLexpbis(node);
    }

    //lexpbis epsilon
    @Override
    public void caseALexpbis(ALexpbis node)
    {
        inALexpbis(node);
        this.returnValue = null;
        outALexpbis(node);
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
        inAPasouExp(node);
        if(node.getE1() != null)
        {
            node.getE1().apply(this);
        }
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
        inAPasetE1(node);
        if(node.getE2() != null)
        {
            node.getE2().apply(this);
        }
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
        inAPasegalinfE2(node);
        if(node.getE3() != null)
        {
            node.getE3().apply(this);
        }
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
        inAPasplusmoinsE3(node);
        if(node.getE4() != null)
        {
            node.getE4().apply(this);
        }
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
        inAPasmuldivE4(node);
        if(node.getE5() != null)
        {
            node.getE5().apply(this);
        }
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
        inAPasnegationE5(node);
        if(node.getE6() != null)
        {
            node.getE6().apply(this);
        }
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
        this.returnValue = new SaExpInt(Integer.parseInt(node.getNombre().getText()));
        outAEnombreE6(node);
    }

    //e6 = {efonction} identif parenthesegauche lexp parenthesedroite
    @Override
    public void caseAEfonctionE6(AEfonctionE6 node)
    {
        SaLExp arg = null;
        inAEfonctionE6(node);
        if(node.getLexp() != null)
        {
            node.getLexp().apply(this);
            arg = (SaLExp) this.returnValue;
        }
        this.returnValue = new SaExpAppel(new SaAppel(node.getIdentif().getText(), arg));
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
        String id = null;
        inAVaridentifVar(node);
        if(node.getIdentif() != null)
        {
            id = node.getIdentif().getText();
        }
        this.returnValue = new SaVarSimple(id);
        outAVaridentifVar(node);
    }

    //var = {varfonction} identif crochetgauche exp crochetdroit
    @Override
    public void caseAVarfonctionVar(AVarfonctionVar node)
    {
        String id = null;
        SaExp op = null;
        inAVarfonctionVar(node);
        if(node.getIdentif() != null)
        {
            id = node.getIdentif().getText();
        }
        if(node.getExp() != null)
        {
            node.getExp().apply(this);
            op = (SaExp) this.returnValue;
        }
        this.returnValue = new SaVarIndicee(id, op);
        outAVarfonctionVar(node);
    }

}
