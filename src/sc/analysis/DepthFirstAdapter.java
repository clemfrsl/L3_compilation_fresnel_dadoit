/* This file was generated by SableCC (http://www.sablecc.org/). */

package sc.analysis;

import java.util.*;
import sc.node.*;

public class DepthFirstAdapter extends AnalysisAdapter
{
    public void inStart(Start node)
    {
        defaultIn(node);
    }

    public void outStart(Start node)
    {
        defaultOut(node);
    }

    public void defaultIn(@SuppressWarnings("unused") Node node)
    {
        // Do nothing
    }

    public void defaultOut(@SuppressWarnings("unused") Node node)
    {
        // Do nothing
    }

    @Override
    public void caseStart(Start node)
    {
        inStart(node);
        node.getPProgramme().apply(this);
        node.getEOF().apply(this);
        outStart(node);
    }

    public void inAProgramme(AProgramme node)
    {
        defaultIn(node);
    }

    public void outAProgramme(AProgramme node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAProgramme(AProgramme node)
    {
        inAProgramme(node);
        if(node.getLdv() != null)
        {
            node.getLdv().apply(this);
        }
        if(node.getLdf() != null)
        {
            node.getLdf().apply(this);
        }
        outAProgramme(node);
    }

    public void inAListedeclarationvariableLdv(AListedeclarationvariableLdv node)
    {
        defaultIn(node);
    }

    public void outAListedeclarationvariableLdv(AListedeclarationvariableLdv node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAListedeclarationvariableLdv(AListedeclarationvariableLdv node)
    {
        inAListedeclarationvariableLdv(node);
        if(node.getDv() != null)
        {
            node.getDv().apply(this);
        }
        if(node.getLdvbis() != null)
        {
            node.getLdvbis().apply(this);
        }
        outAListedeclarationvariableLdv(node);
    }

    public void inALdv(ALdv node)
    {
        defaultIn(node);
    }

    public void outALdv(ALdv node)
    {
        defaultOut(node);
    }

    @Override
    public void caseALdv(ALdv node)
    {
        inALdv(node);
        outALdv(node);
    }

    public void inAListedeclarationvariablebisLdvbis(AListedeclarationvariablebisLdvbis node)
    {
        defaultIn(node);
    }

    public void outAListedeclarationvariablebisLdvbis(AListedeclarationvariablebisLdvbis node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAListedeclarationvariablebisLdvbis(AListedeclarationvariablebisLdvbis node)
    {
        inAListedeclarationvariablebisLdvbis(node);
        if(node.getVirgule() != null)
        {
            node.getVirgule().apply(this);
        }
        if(node.getDv() != null)
        {
            node.getDv().apply(this);
        }
        if(node.getLdvbis() != null)
        {
            node.getLdvbis().apply(this);
        }
        outAListedeclarationvariablebisLdvbis(node);
    }

    public void inALdvbis(ALdvbis node)
    {
        defaultIn(node);
    }

    public void outALdvbis(ALdvbis node)
    {
        defaultOut(node);
    }

    @Override
    public void caseALdvbis(ALdvbis node)
    {
        inALdvbis(node);
        outALdvbis(node);
    }

    public void inADeclarationvariableidDv(ADeclarationvariableidDv node)
    {
        defaultIn(node);
    }

    public void outADeclarationvariableidDv(ADeclarationvariableidDv node)
    {
        defaultOut(node);
    }

    @Override
    public void caseADeclarationvariableidDv(ADeclarationvariableidDv node)
    {
        inADeclarationvariableidDv(node);
        if(node.getTv() != null)
        {
            node.getTv().apply(this);
        }
        if(node.getIdentif() != null)
        {
            node.getIdentif().apply(this);
        }
        outADeclarationvariableidDv(node);
    }

    public void inADeclarationvariableidtableauDv(ADeclarationvariableidtableauDv node)
    {
        defaultIn(node);
    }

    public void outADeclarationvariableidtableauDv(ADeclarationvariableidtableauDv node)
    {
        defaultOut(node);
    }

    @Override
    public void caseADeclarationvariableidtableauDv(ADeclarationvariableidtableauDv node)
    {
        inADeclarationvariableidtableauDv(node);
        if(node.getTv() != null)
        {
            node.getTv().apply(this);
        }
        if(node.getIdentif() != null)
        {
            node.getIdentif().apply(this);
        }
        if(node.getCrochetgauche() != null)
        {
            node.getCrochetgauche().apply(this);
        }
        if(node.getNombre() != null)
        {
            node.getNombre().apply(this);
        }
        if(node.getCrochetdroit() != null)
        {
            node.getCrochetdroit().apply(this);
        }
        outADeclarationvariableidtableauDv(node);
    }

    public void inAListedeclarationfonctionLdf(AListedeclarationfonctionLdf node)
    {
        defaultIn(node);
    }

    public void outAListedeclarationfonctionLdf(AListedeclarationfonctionLdf node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAListedeclarationfonctionLdf(AListedeclarationfonctionLdf node)
    {
        inAListedeclarationfonctionLdf(node);
        if(node.getDf() != null)
        {
            node.getDf().apply(this);
        }
        if(node.getLdf() != null)
        {
            node.getLdf().apply(this);
        }
        outAListedeclarationfonctionLdf(node);
    }

    public void inALdf(ALdf node)
    {
        defaultIn(node);
    }

    public void outALdf(ALdf node)
    {
        defaultOut(node);
    }

    @Override
    public void caseALdf(ALdf node)
    {
        inALdf(node);
        outALdf(node);
    }

    public void inATypeboolTv(ATypeboolTv node)
    {
        defaultIn(node);
    }

    public void outATypeboolTv(ATypeboolTv node)
    {
        defaultOut(node);
    }

    @Override
    public void caseATypeboolTv(ATypeboolTv node)
    {
        inATypeboolTv(node);
        if(node.getBoolean() != null)
        {
            node.getBoolean().apply(this);
        }
        outATypeboolTv(node);
    }

    public void inATypeentierTv(ATypeentierTv node)
    {
        defaultIn(node);
    }

    public void outATypeentierTv(ATypeentierTv node)
    {
        defaultOut(node);
    }

    @Override
    public void caseATypeentierTv(ATypeentierTv node)
    {
        inATypeentierTv(node);
        if(node.getEntier() != null)
        {
            node.getEntier().apply(this);
        }
        outATypeentierTv(node);
    }

    public void inADf(ADf node)
    {
        defaultIn(node);
    }

    public void outADf(ADf node)
    {
        defaultOut(node);
    }

    @Override
    public void caseADf(ADf node)
    {
        inADf(node);
        if(node.getTo() != null)
        {
            node.getTo().apply(this);
        }
        if(node.getIdentif() != null)
        {
            node.getIdentif().apply(this);
        }
        if(node.getParenthesegauche() != null)
        {
            node.getParenthesegauche().apply(this);
        }
        if(node.getPremier() != null)
        {
            node.getPremier().apply(this);
        }
        if(node.getParenthesedroite() != null)
        {
            node.getParenthesedroite().apply(this);
        }
        if(node.getSecond() != null)
        {
            node.getSecond().apply(this);
        }
        if(node.getBi() != null)
        {
            node.getBi().apply(this);
        }
        outADf(node);
    }

    public void inATypeoptionelTo(ATypeoptionelTo node)
    {
        defaultIn(node);
    }

    public void outATypeoptionelTo(ATypeoptionelTo node)
    {
        defaultOut(node);
    }

    @Override
    public void caseATypeoptionelTo(ATypeoptionelTo node)
    {
        inATypeoptionelTo(node);
        if(node.getTv() != null)
        {
            node.getTv().apply(this);
        }
        outATypeoptionelTo(node);
    }

    public void inATo(ATo node)
    {
        defaultIn(node);
    }

    public void outATo(ATo node)
    {
        defaultOut(node);
    }

    @Override
    public void caseATo(ATo node)
    {
        inATo(node);
        outATo(node);
    }

    public void inABi(ABi node)
    {
        defaultIn(node);
    }

    public void outABi(ABi node)
    {
        defaultOut(node);
    }

    @Override
    public void caseABi(ABi node)
    {
        inABi(node);
        if(node.getAccoladegauche() != null)
        {
            node.getAccoladegauche().apply(this);
        }
        if(node.getLi() != null)
        {
            node.getLi().apply(this);
        }
        if(node.getAccoladedroite() != null)
        {
            node.getAccoladedroite().apply(this);
        }
        outABi(node);
    }

    public void inAListeinstructionLi(AListeinstructionLi node)
    {
        defaultIn(node);
    }

    public void outAListeinstructionLi(AListeinstructionLi node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAListeinstructionLi(AListeinstructionLi node)
    {
        inAListeinstructionLi(node);
        if(node.getInst() != null)
        {
            node.getInst().apply(this);
        }
        if(node.getLi() != null)
        {
            node.getLi().apply(this);
        }
        outAListeinstructionLi(node);
    }

    public void inALi(ALi node)
    {
        defaultIn(node);
    }

    public void outALi(ALi node)
    {
        defaultOut(node);
    }

    @Override
    public void caseALi(ALi node)
    {
        inALi(node);
        outALi(node);
    }

    public void inAAssignationInst(AAssignationInst node)
    {
        defaultIn(node);
    }

    public void outAAssignationInst(AAssignationInst node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAAssignationInst(AAssignationInst node)
    {
        inAAssignationInst(node);
        if(node.getVar() != null)
        {
            node.getVar().apply(this);
        }
        if(node.getEgal() != null)
        {
            node.getEgal().apply(this);
        }
        if(node.getExp() != null)
        {
            node.getExp().apply(this);
        }
        if(node.getPointvirgule() != null)
        {
            node.getPointvirgule().apply(this);
        }
        outAAssignationInst(node);
    }

    public void inABoucletantqueInst(ABoucletantqueInst node)
    {
        defaultIn(node);
    }

    public void outABoucletantqueInst(ABoucletantqueInst node)
    {
        defaultOut(node);
    }

    @Override
    public void caseABoucletantqueInst(ABoucletantqueInst node)
    {
        inABoucletantqueInst(node);
        if(node.getTantque() != null)
        {
            node.getTantque().apply(this);
        }
        if(node.getExp() != null)
        {
            node.getExp().apply(this);
        }
        if(node.getFaire() != null)
        {
            node.getFaire().apply(this);
        }
        if(node.getBi() != null)
        {
            node.getBi().apply(this);
        }
        outABoucletantqueInst(node);
    }

    public void inASialorsInst(ASialorsInst node)
    {
        defaultIn(node);
    }

    public void outASialorsInst(ASialorsInst node)
    {
        defaultOut(node);
    }

    @Override
    public void caseASialorsInst(ASialorsInst node)
    {
        inASialorsInst(node);
        if(node.getSi() != null)
        {
            node.getSi().apply(this);
        }
        if(node.getExp() != null)
        {
            node.getExp().apply(this);
        }
        if(node.getAlors() != null)
        {
            node.getAlors().apply(this);
        }
        if(node.getBi() != null)
        {
            node.getBi().apply(this);
        }
        outASialorsInst(node);
    }

    public void inASialorssinonInst(ASialorssinonInst node)
    {
        defaultIn(node);
    }

    public void outASialorssinonInst(ASialorssinonInst node)
    {
        defaultOut(node);
    }

    @Override
    public void caseASialorssinonInst(ASialorssinonInst node)
    {
        inASialorssinonInst(node);
        if(node.getSi() != null)
        {
            node.getSi().apply(this);
        }
        if(node.getExp() != null)
        {
            node.getExp().apply(this);
        }
        if(node.getAlors() != null)
        {
            node.getAlors().apply(this);
        }
        if(node.getPremier() != null)
        {
            node.getPremier().apply(this);
        }
        if(node.getSinon() != null)
        {
            node.getSinon().apply(this);
        }
        if(node.getSecond() != null)
        {
            node.getSecond().apply(this);
        }
        outASialorssinonInst(node);
    }

    public void inARetourInst(ARetourInst node)
    {
        defaultIn(node);
    }

    public void outARetourInst(ARetourInst node)
    {
        defaultOut(node);
    }

    @Override
    public void caseARetourInst(ARetourInst node)
    {
        inARetourInst(node);
        if(node.getRetour() != null)
        {
            node.getRetour().apply(this);
        }
        if(node.getExp() != null)
        {
            node.getExp().apply(this);
        }
        if(node.getPointvirgule() != null)
        {
            node.getPointvirgule().apply(this);
        }
        outARetourInst(node);
    }

    public void inAFonctionecrireInst(AFonctionecrireInst node)
    {
        defaultIn(node);
    }

    public void outAFonctionecrireInst(AFonctionecrireInst node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAFonctionecrireInst(AFonctionecrireInst node)
    {
        inAFonctionecrireInst(node);
        if(node.getEcrire() != null)
        {
            node.getEcrire().apply(this);
        }
        if(node.getParenthesegauche() != null)
        {
            node.getParenthesegauche().apply(this);
        }
        if(node.getExp() != null)
        {
            node.getExp().apply(this);
        }
        if(node.getParenthesedroite() != null)
        {
            node.getParenthesedroite().apply(this);
        }
        if(node.getPointvirgule() != null)
        {
            node.getPointvirgule().apply(this);
        }
        outAFonctionecrireInst(node);
    }

    public void inAAppelfonctionInst(AAppelfonctionInst node)
    {
        defaultIn(node);
    }

    public void outAAppelfonctionInst(AAppelfonctionInst node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAAppelfonctionInst(AAppelfonctionInst node)
    {
        inAAppelfonctionInst(node);
        if(node.getIdentif() != null)
        {
            node.getIdentif().apply(this);
        }
        if(node.getParenthesegauche() != null)
        {
            node.getParenthesegauche().apply(this);
        }
        if(node.getLexp() != null)
        {
            node.getLexp().apply(this);
        }
        if(node.getParenthesedroite() != null)
        {
            node.getParenthesedroite().apply(this);
        }
        if(node.getPointvirgule() != null)
        {
            node.getPointvirgule().apply(this);
        }
        outAAppelfonctionInst(node);
    }

    public void inAListeexprLexp(AListeexprLexp node)
    {
        defaultIn(node);
    }

    public void outAListeexprLexp(AListeexprLexp node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAListeexprLexp(AListeexprLexp node)
    {
        inAListeexprLexp(node);
        if(node.getExp() != null)
        {
            node.getExp().apply(this);
        }
        if(node.getLexpbis() != null)
        {
            node.getLexpbis().apply(this);
        }
        outAListeexprLexp(node);
    }

    public void inALexp(ALexp node)
    {
        defaultIn(node);
    }

    public void outALexp(ALexp node)
    {
        defaultOut(node);
    }

    @Override
    public void caseALexp(ALexp node)
    {
        inALexp(node);
        outALexp(node);
    }

    public void inAListeexprbisLexpbis(AListeexprbisLexpbis node)
    {
        defaultIn(node);
    }

    public void outAListeexprbisLexpbis(AListeexprbisLexpbis node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAListeexprbisLexpbis(AListeexprbisLexpbis node)
    {
        inAListeexprbisLexpbis(node);
        if(node.getVirgule() != null)
        {
            node.getVirgule().apply(this);
        }
        if(node.getExp() != null)
        {
            node.getExp().apply(this);
        }
        if(node.getLexpbis() != null)
        {
            node.getLexpbis().apply(this);
        }
        outAListeexprbisLexpbis(node);
    }

    public void inALexpbis(ALexpbis node)
    {
        defaultIn(node);
    }

    public void outALexpbis(ALexpbis node)
    {
        defaultOut(node);
    }

    @Override
    public void caseALexpbis(ALexpbis node)
    {
        inALexpbis(node);
        outALexpbis(node);
    }

    public void inAOuExp(AOuExp node)
    {
        defaultIn(node);
    }

    public void outAOuExp(AOuExp node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAOuExp(AOuExp node)
    {
        inAOuExp(node);
        if(node.getExp() != null)
        {
            node.getExp().apply(this);
        }
        if(node.getOu() != null)
        {
            node.getOu().apply(this);
        }
        if(node.getE1() != null)
        {
            node.getE1().apply(this);
        }
        outAOuExp(node);
    }

    public void inAPasouExp(APasouExp node)
    {
        defaultIn(node);
    }

    public void outAPasouExp(APasouExp node)
    {
        defaultOut(node);
    }

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

    public void inAEtE1(AEtE1 node)
    {
        defaultIn(node);
    }

    public void outAEtE1(AEtE1 node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAEtE1(AEtE1 node)
    {
        inAEtE1(node);
        if(node.getE1() != null)
        {
            node.getE1().apply(this);
        }
        if(node.getEt() != null)
        {
            node.getEt().apply(this);
        }
        if(node.getE2() != null)
        {
            node.getE2().apply(this);
        }
        outAEtE1(node);
    }

    public void inAPasetE1(APasetE1 node)
    {
        defaultIn(node);
    }

    public void outAPasetE1(APasetE1 node)
    {
        defaultOut(node);
    }

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

    public void inAEgalE2(AEgalE2 node)
    {
        defaultIn(node);
    }

    public void outAEgalE2(AEgalE2 node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAEgalE2(AEgalE2 node)
    {
        inAEgalE2(node);
        if(node.getE2() != null)
        {
            node.getE2().apply(this);
        }
        if(node.getEgal() != null)
        {
            node.getEgal().apply(this);
        }
        if(node.getE3() != null)
        {
            node.getE3().apply(this);
        }
        outAEgalE2(node);
    }

    public void inAInfE2(AInfE2 node)
    {
        defaultIn(node);
    }

    public void outAInfE2(AInfE2 node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAInfE2(AInfE2 node)
    {
        inAInfE2(node);
        if(node.getE2() != null)
        {
            node.getE2().apply(this);
        }
        if(node.getInf() != null)
        {
            node.getInf().apply(this);
        }
        if(node.getE3() != null)
        {
            node.getE3().apply(this);
        }
        outAInfE2(node);
    }

    public void inAPasegalinfE2(APasegalinfE2 node)
    {
        defaultIn(node);
    }

    public void outAPasegalinfE2(APasegalinfE2 node)
    {
        defaultOut(node);
    }

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

    public void inAPlusE3(APlusE3 node)
    {
        defaultIn(node);
    }

    public void outAPlusE3(APlusE3 node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAPlusE3(APlusE3 node)
    {
        inAPlusE3(node);
        if(node.getE3() != null)
        {
            node.getE3().apply(this);
        }
        if(node.getPlus() != null)
        {
            node.getPlus().apply(this);
        }
        if(node.getE4() != null)
        {
            node.getE4().apply(this);
        }
        outAPlusE3(node);
    }

    public void inAMoinsE3(AMoinsE3 node)
    {
        defaultIn(node);
    }

    public void outAMoinsE3(AMoinsE3 node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAMoinsE3(AMoinsE3 node)
    {
        inAMoinsE3(node);
        if(node.getE3() != null)
        {
            node.getE3().apply(this);
        }
        if(node.getMoins() != null)
        {
            node.getMoins().apply(this);
        }
        if(node.getE4() != null)
        {
            node.getE4().apply(this);
        }
        outAMoinsE3(node);
    }

    public void inAPasplusmoinsE3(APasplusmoinsE3 node)
    {
        defaultIn(node);
    }

    public void outAPasplusmoinsE3(APasplusmoinsE3 node)
    {
        defaultOut(node);
    }

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

    public void inAMulE4(AMulE4 node)
    {
        defaultIn(node);
    }

    public void outAMulE4(AMulE4 node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAMulE4(AMulE4 node)
    {
        inAMulE4(node);
        if(node.getE4() != null)
        {
            node.getE4().apply(this);
        }
        if(node.getMul() != null)
        {
            node.getMul().apply(this);
        }
        if(node.getE5() != null)
        {
            node.getE5().apply(this);
        }
        outAMulE4(node);
    }

    public void inADivE4(ADivE4 node)
    {
        defaultIn(node);
    }

    public void outADivE4(ADivE4 node)
    {
        defaultOut(node);
    }

    @Override
    public void caseADivE4(ADivE4 node)
    {
        inADivE4(node);
        if(node.getE4() != null)
        {
            node.getE4().apply(this);
        }
        if(node.getDiv() != null)
        {
            node.getDiv().apply(this);
        }
        if(node.getE5() != null)
        {
            node.getE5().apply(this);
        }
        outADivE4(node);
    }

    public void inAPasmuldivE4(APasmuldivE4 node)
    {
        defaultIn(node);
    }

    public void outAPasmuldivE4(APasmuldivE4 node)
    {
        defaultOut(node);
    }

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

    public void inANegationE5(ANegationE5 node)
    {
        defaultIn(node);
    }

    public void outANegationE5(ANegationE5 node)
    {
        defaultOut(node);
    }

    @Override
    public void caseANegationE5(ANegationE5 node)
    {
        inANegationE5(node);
        if(node.getNon() != null)
        {
            node.getNon().apply(this);
        }
        if(node.getE5() != null)
        {
            node.getE5().apply(this);
        }
        outANegationE5(node);
    }

    public void inAPasnegationE5(APasnegationE5 node)
    {
        defaultIn(node);
    }

    public void outAPasnegationE5(APasnegationE5 node)
    {
        defaultOut(node);
    }

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

    public void inAEboucleexprE6(AEboucleexprE6 node)
    {
        defaultIn(node);
    }

    public void outAEboucleexprE6(AEboucleexprE6 node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAEboucleexprE6(AEboucleexprE6 node)
    {
        inAEboucleexprE6(node);
        if(node.getParenthesegauche() != null)
        {
            node.getParenthesegauche().apply(this);
        }
        if(node.getExp() != null)
        {
            node.getExp().apply(this);
        }
        if(node.getParenthesedroite() != null)
        {
            node.getParenthesedroite().apply(this);
        }
        outAEboucleexprE6(node);
    }

    public void inAEvarE6(AEvarE6 node)
    {
        defaultIn(node);
    }

    public void outAEvarE6(AEvarE6 node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAEvarE6(AEvarE6 node)
    {
        inAEvarE6(node);
        if(node.getVar() != null)
        {
            node.getVar().apply(this);
        }
        outAEvarE6(node);
    }

    public void inAEnombreE6(AEnombreE6 node)
    {
        defaultIn(node);
    }

    public void outAEnombreE6(AEnombreE6 node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAEnombreE6(AEnombreE6 node)
    {
        inAEnombreE6(node);
        if(node.getNombre() != null)
        {
            node.getNombre().apply(this);
        }
        outAEnombreE6(node);
    }

    public void inAEfonctionE6(AEfonctionE6 node)
    {
        defaultIn(node);
    }

    public void outAEfonctionE6(AEfonctionE6 node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAEfonctionE6(AEfonctionE6 node)
    {
        inAEfonctionE6(node);
        if(node.getIdentif() != null)
        {
            node.getIdentif().apply(this);
        }
        if(node.getParenthesegauche() != null)
        {
            node.getParenthesegauche().apply(this);
        }
        if(node.getLexp() != null)
        {
            node.getLexp().apply(this);
        }
        if(node.getParenthesedroite() != null)
        {
            node.getParenthesedroite().apply(this);
        }
        outAEfonctionE6(node);
    }

    public void inAElireE6(AElireE6 node)
    {
        defaultIn(node);
    }

    public void outAElireE6(AElireE6 node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAElireE6(AElireE6 node)
    {
        inAElireE6(node);
        if(node.getLire() != null)
        {
            node.getLire().apply(this);
        }
        if(node.getParenthesegauche() != null)
        {
            node.getParenthesegauche().apply(this);
        }
        if(node.getParenthesedroite() != null)
        {
            node.getParenthesedroite().apply(this);
        }
        outAElireE6(node);
    }

    public void inAEvraiE6(AEvraiE6 node)
    {
        defaultIn(node);
    }

    public void outAEvraiE6(AEvraiE6 node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAEvraiE6(AEvraiE6 node)
    {
        inAEvraiE6(node);
        if(node.getVrai() != null)
        {
            node.getVrai().apply(this);
        }
        outAEvraiE6(node);
    }

    public void inAEfauxE6(AEfauxE6 node)
    {
        defaultIn(node);
    }

    public void outAEfauxE6(AEfauxE6 node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAEfauxE6(AEfauxE6 node)
    {
        inAEfauxE6(node);
        if(node.getFaux() != null)
        {
            node.getFaux().apply(this);
        }
        outAEfauxE6(node);
    }

    public void inAVaridentifVar(AVaridentifVar node)
    {
        defaultIn(node);
    }

    public void outAVaridentifVar(AVaridentifVar node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAVaridentifVar(AVaridentifVar node)
    {
        inAVaridentifVar(node);
        if(node.getIdentif() != null)
        {
            node.getIdentif().apply(this);
        }
        outAVaridentifVar(node);
    }

    public void inAVarfonctionVar(AVarfonctionVar node)
    {
        defaultIn(node);
    }

    public void outAVarfonctionVar(AVarfonctionVar node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAVarfonctionVar(AVarfonctionVar node)
    {
        inAVarfonctionVar(node);
        if(node.getIdentif() != null)
        {
            node.getIdentif().apply(this);
        }
        if(node.getCrochetgauche() != null)
        {
            node.getCrochetgauche().apply(this);
        }
        if(node.getExp() != null)
        {
            node.getExp().apply(this);
        }
        if(node.getCrochetdroit() != null)
        {
            node.getCrochetdroit().apply(this);
        }
        outAVarfonctionVar(node);
    }
}
