/* This file was generated by SableCC (http://www.sablecc.org/). */

package sc.node;

import sc.analysis.*;

@SuppressWarnings("nls")
public final class ABi extends PBi
{
    private TAccoladegauche _accoladegauche_;
    private PLi _li_;
    private TAccoladedroite _accoladedroite_;

    public ABi()
    {
        // Constructor
    }

    public ABi(
        @SuppressWarnings("hiding") TAccoladegauche _accoladegauche_,
        @SuppressWarnings("hiding") PLi _li_,
        @SuppressWarnings("hiding") TAccoladedroite _accoladedroite_)
    {
        // Constructor
        setAccoladegauche(_accoladegauche_);

        setLi(_li_);

        setAccoladedroite(_accoladedroite_);

    }

    @Override
    public Object clone()
    {
        return new ABi(
            cloneNode(this._accoladegauche_),
            cloneNode(this._li_),
            cloneNode(this._accoladedroite_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseABi(this);
    }

    public TAccoladegauche getAccoladegauche()
    {
        return this._accoladegauche_;
    }

    public void setAccoladegauche(TAccoladegauche node)
    {
        if(this._accoladegauche_ != null)
        {
            this._accoladegauche_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._accoladegauche_ = node;
    }

    public PLi getLi()
    {
        return this._li_;
    }

    public void setLi(PLi node)
    {
        if(this._li_ != null)
        {
            this._li_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._li_ = node;
    }

    public TAccoladedroite getAccoladedroite()
    {
        return this._accoladedroite_;
    }

    public void setAccoladedroite(TAccoladedroite node)
    {
        if(this._accoladedroite_ != null)
        {
            this._accoladedroite_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._accoladedroite_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._accoladegauche_)
            + toString(this._li_)
            + toString(this._accoladedroite_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._accoladegauche_ == child)
        {
            this._accoladegauche_ = null;
            return;
        }

        if(this._li_ == child)
        {
            this._li_ = null;
            return;
        }

        if(this._accoladedroite_ == child)
        {
            this._accoladedroite_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._accoladegauche_ == oldChild)
        {
            setAccoladegauche((TAccoladegauche) newChild);
            return;
        }

        if(this._li_ == oldChild)
        {
            setLi((PLi) newChild);
            return;
        }

        if(this._accoladedroite_ == oldChild)
        {
            setAccoladedroite((TAccoladedroite) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
