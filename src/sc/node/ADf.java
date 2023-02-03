/* This file was generated by SableCC (http://www.sablecc.org/). */

package sc.node;

import sc.analysis.*;

@SuppressWarnings("nls")
public final class ADf extends PDf
{
    private PTo _to_;
    private TIdentif _identif_;
    private TParenthesegauche _parenthesegauche_;
    private PLdv _premier_;
    private TParenthesedroite _parenthesedroite_;
    private PLdv _second_;
    private PBi _bi_;

    public ADf()
    {
        // Constructor
    }

    public ADf(
        @SuppressWarnings("hiding") PTo _to_,
        @SuppressWarnings("hiding") TIdentif _identif_,
        @SuppressWarnings("hiding") TParenthesegauche _parenthesegauche_,
        @SuppressWarnings("hiding") PLdv _premier_,
        @SuppressWarnings("hiding") TParenthesedroite _parenthesedroite_,
        @SuppressWarnings("hiding") PLdv _second_,
        @SuppressWarnings("hiding") PBi _bi_)
    {
        // Constructor
        setTo(_to_);

        setIdentif(_identif_);

        setParenthesegauche(_parenthesegauche_);

        setPremier(_premier_);

        setParenthesedroite(_parenthesedroite_);

        setSecond(_second_);

        setBi(_bi_);

    }

    @Override
    public Object clone()
    {
        return new ADf(
            cloneNode(this._to_),
            cloneNode(this._identif_),
            cloneNode(this._parenthesegauche_),
            cloneNode(this._premier_),
            cloneNode(this._parenthesedroite_),
            cloneNode(this._second_),
            cloneNode(this._bi_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseADf(this);
    }

    public PTo getTo()
    {
        return this._to_;
    }

    public void setTo(PTo node)
    {
        if(this._to_ != null)
        {
            this._to_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._to_ = node;
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

    public PLdv getPremier()
    {
        return this._premier_;
    }

    public void setPremier(PLdv node)
    {
        if(this._premier_ != null)
        {
            this._premier_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._premier_ = node;
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

    public PLdv getSecond()
    {
        return this._second_;
    }

    public void setSecond(PLdv node)
    {
        if(this._second_ != null)
        {
            this._second_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._second_ = node;
    }

    public PBi getBi()
    {
        return this._bi_;
    }

    public void setBi(PBi node)
    {
        if(this._bi_ != null)
        {
            this._bi_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._bi_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._to_)
            + toString(this._identif_)
            + toString(this._parenthesegauche_)
            + toString(this._premier_)
            + toString(this._parenthesedroite_)
            + toString(this._second_)
            + toString(this._bi_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._to_ == child)
        {
            this._to_ = null;
            return;
        }

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

        if(this._premier_ == child)
        {
            this._premier_ = null;
            return;
        }

        if(this._parenthesedroite_ == child)
        {
            this._parenthesedroite_ = null;
            return;
        }

        if(this._second_ == child)
        {
            this._second_ = null;
            return;
        }

        if(this._bi_ == child)
        {
            this._bi_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._to_ == oldChild)
        {
            setTo((PTo) newChild);
            return;
        }

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

        if(this._premier_ == oldChild)
        {
            setPremier((PLdv) newChild);
            return;
        }

        if(this._parenthesedroite_ == oldChild)
        {
            setParenthesedroite((TParenthesedroite) newChild);
            return;
        }

        if(this._second_ == oldChild)
        {
            setSecond((PLdv) newChild);
            return;
        }

        if(this._bi_ == oldChild)
        {
            setBi((PBi) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}