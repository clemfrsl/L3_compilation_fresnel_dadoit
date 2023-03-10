/* This file was generated by SableCC (http://www.sablecc.org/). */

package sc.node;

import sc.analysis.*;

@SuppressWarnings("nls")
public final class ARetourInst extends PInst
{
    private TRetour _retour_;
    private PExp _exp_;
    private TPointvirgule _pointvirgule_;

    public ARetourInst()
    {
        // Constructor
    }

    public ARetourInst(
        @SuppressWarnings("hiding") TRetour _retour_,
        @SuppressWarnings("hiding") PExp _exp_,
        @SuppressWarnings("hiding") TPointvirgule _pointvirgule_)
    {
        // Constructor
        setRetour(_retour_);

        setExp(_exp_);

        setPointvirgule(_pointvirgule_);

    }

    @Override
    public Object clone()
    {
        return new ARetourInst(
            cloneNode(this._retour_),
            cloneNode(this._exp_),
            cloneNode(this._pointvirgule_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseARetourInst(this);
    }

    public TRetour getRetour()
    {
        return this._retour_;
    }

    public void setRetour(TRetour node)
    {
        if(this._retour_ != null)
        {
            this._retour_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._retour_ = node;
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
            + toString(this._retour_)
            + toString(this._exp_)
            + toString(this._pointvirgule_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._retour_ == child)
        {
            this._retour_ = null;
            return;
        }

        if(this._exp_ == child)
        {
            this._exp_ = null;
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
        if(this._retour_ == oldChild)
        {
            setRetour((TRetour) newChild);
            return;
        }

        if(this._exp_ == oldChild)
        {
            setExp((PExp) newChild);
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
