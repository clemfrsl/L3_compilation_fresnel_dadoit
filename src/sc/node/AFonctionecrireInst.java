/* This file was generated by SableCC (http://www.sablecc.org/). */

package sc.node;

import sc.analysis.*;

@SuppressWarnings("nls")
public final class AFonctionecrireInst extends PInst
{
    private TEcrire _ecrire_;
    private TParenthesegauche _parenthesegauche_;
    private PExp _exp_;
    private TParenthesedroite _parenthesedroite_;
    private TPointvirgule _pointvirgule_;

    public AFonctionecrireInst()
    {
        // Constructor
    }

    public AFonctionecrireInst(
        @SuppressWarnings("hiding") TEcrire _ecrire_,
        @SuppressWarnings("hiding") TParenthesegauche _parenthesegauche_,
        @SuppressWarnings("hiding") PExp _exp_,
        @SuppressWarnings("hiding") TParenthesedroite _parenthesedroite_,
        @SuppressWarnings("hiding") TPointvirgule _pointvirgule_)
    {
        // Constructor
        setEcrire(_ecrire_);

        setParenthesegauche(_parenthesegauche_);

        setExp(_exp_);

        setParenthesedroite(_parenthesedroite_);

        setPointvirgule(_pointvirgule_);

    }

    @Override
    public Object clone()
    {
        return new AFonctionecrireInst(
            cloneNode(this._ecrire_),
            cloneNode(this._parenthesegauche_),
            cloneNode(this._exp_),
            cloneNode(this._parenthesedroite_),
            cloneNode(this._pointvirgule_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAFonctionecrireInst(this);
    }

    public TEcrire getEcrire()
    {
        return this._ecrire_;
    }

    public void setEcrire(TEcrire node)
    {
        if(this._ecrire_ != null)
        {
            this._ecrire_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._ecrire_ = node;
    }

    public TParenthesegauche getParenthesegauche()
    {
        return this._parenthesegauche_;
    }

    public void setParenthesegauche(TParenthesegauche node)
    {
        if(this._parenthesegauche_ != null)
        {
            this._parenthesegauche_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._parenthesegauche_ = node;
    }

    public PExp getExp()
    {
        return this._exp_;
    }

    public void setExp(PExp node)
    {
        if(this._exp_ != null)
        {
            this._exp_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._exp_ = node;
    }

    public TParenthesedroite getParenthesedroite()
    {
        return this._parenthesedroite_;
    }

    public void setParenthesedroite(TParenthesedroite node)
    {
        if(this._parenthesedroite_ != null)
        {
            this._parenthesedroite_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._parenthesedroite_ = node;
    }

    public TPointvirgule getPointvirgule()
    {
        return this._pointvirgule_;
    }

    public void setPointvirgule(TPointvirgule node)
    {
        if(this._pointvirgule_ != null)
        {
            this._pointvirgule_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._pointvirgule_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._ecrire_)
            + toString(this._parenthesegauche_)
            + toString(this._exp_)
            + toString(this._parenthesedroite_)
            + toString(this._pointvirgule_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._ecrire_ == child)
        {
            this._ecrire_ = null;
            return;
        }

        if(this._parenthesegauche_ == child)
        {
            this._parenthesegauche_ = null;
            return;
        }

        if(this._exp_ == child)
        {
            this._exp_ = null;
            return;
        }

        if(this._parenthesedroite_ == child)
        {
            this._parenthesedroite_ = null;
            return;
        }

        if(this._pointvirgule_ == child)
        {
            this._pointvirgule_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._ecrire_ == oldChild)
        {
            setEcrire((TEcrire) newChild);
            return;
        }

        if(this._parenthesegauche_ == oldChild)
        {
            setParenthesegauche((TParenthesegauche) newChild);
            return;
        }

        if(this._exp_ == oldChild)
        {
            setExp((PExp) newChild);
            return;
        }

        if(this._parenthesedroite_ == oldChild)
        {
            setParenthesedroite((TParenthesedroite) newChild);
            return;
        }

        if(this._pointvirgule_ == oldChild)
        {
            setPointvirgule((TPointvirgule) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}