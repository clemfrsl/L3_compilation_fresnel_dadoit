/* This file was generated by SableCC (http://www.sablecc.org/). */

package sc.node;

import sc.analysis.*;

@SuppressWarnings("nls")
public final class AAppelfonctionInst extends PInst
{
    private TIdentif _identif_;
    private TParenthesegauche _parenthesegauche_;
    private PLexp _lexp_;
    private TParenthesedroite _parenthesedroite_;
    private TPointvirgule _pointvirgule_;

    public AAppelfonctionInst()
    {
        // Constructor
    }

    public AAppelfonctionInst(
        @SuppressWarnings("hiding") TIdentif _identif_,
        @SuppressWarnings("hiding") TParenthesegauche _parenthesegauche_,
        @SuppressWarnings("hiding") PLexp _lexp_,
        @SuppressWarnings("hiding") TParenthesedroite _parenthesedroite_,
        @SuppressWarnings("hiding") TPointvirgule _pointvirgule_)
    {
        // Constructor
        setIdentif(_identif_);

        setParenthesegauche(_parenthesegauche_);

        setLexp(_lexp_);

        setParenthesedroite(_parenthesedroite_);

        setPointvirgule(_pointvirgule_);

    }

    @Override
    public Object clone()
    {
        return new AAppelfonctionInst(
            cloneNode(this._identif_),
            cloneNode(this._parenthesegauche_),
            cloneNode(this._lexp_),
            cloneNode(this._parenthesedroite_),
            cloneNode(this._pointvirgule_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAAppelfonctionInst(this);
    }

    public TIdentif getIdentif()
    {
        return this._identif_;
    }

    public void setIdentif(TIdentif node)
    {
        if(this._identif_ != null)
        {
            this._identif_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._identif_ = node;
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

    public PLexp getLexp()
    {
        return this._lexp_;
    }

    public void setLexp(PLexp node)
    {
        if(this._lexp_ != null)
        {
            this._lexp_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._lexp_ = node;
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
            + toString(this._identif_)
            + toString(this._parenthesegauche_)
            + toString(this._lexp_)
            + toString(this._parenthesedroite_)
            + toString(this._pointvirgule_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._identif_ == child)
        {
            this._identif_ = null;
            return;
        }

        if(this._parenthesegauche_ == child)
        {
            this._parenthesegauche_ = null;
            return;
        }

        if(this._lexp_ == child)
        {
            this._lexp_ = null;
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
        if(this._identif_ == oldChild)
        {
            setIdentif((TIdentif) newChild);
            return;
        }

        if(this._parenthesegauche_ == oldChild)
        {
            setParenthesegauche((TParenthesegauche) newChild);
            return;
        }

        if(this._lexp_ == oldChild)
        {
            setLexp((PLexp) newChild);
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
