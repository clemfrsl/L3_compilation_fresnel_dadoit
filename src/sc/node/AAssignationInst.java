/* This file was generated by SableCC (http://www.sablecc.org/). */

package sc.node;

import sc.analysis.*;

@SuppressWarnings("nls")
public final class AAssignationInst extends PInst
{
    private PVar _var_;
    private TEgal _egal_;
    private PExp _exp_;
    private TPointvirgule _pointvirgule_;

    public AAssignationInst()
    {
        // Constructor
    }

    public AAssignationInst(
        @SuppressWarnings("hiding") PVar _var_,
        @SuppressWarnings("hiding") TEgal _egal_,
        @SuppressWarnings("hiding") PExp _exp_,
        @SuppressWarnings("hiding") TPointvirgule _pointvirgule_)
    {
        // Constructor
        setVar(_var_);

        setEgal(_egal_);

        setExp(_exp_);

        setPointvirgule(_pointvirgule_);

    }

    @Override
    public Object clone()
    {
        return new AAssignationInst(
            cloneNode(this._var_),
            cloneNode(this._egal_),
            cloneNode(this._exp_),
            cloneNode(this._pointvirgule_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAAssignationInst(this);
    }

    public PVar getVar()
    {
        return this._var_;
    }

    public void setVar(PVar node)
    {
        if(this._var_ != null)
        {
            this._var_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._var_ = node;
    }

    public TEgal getEgal()
    {
        return this._egal_;
    }

    public void setEgal(TEgal node)
    {
        if(this._egal_ != null)
        {
            this._egal_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._egal_ = node;
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
            + toString(this._var_)
            + toString(this._egal_)
            + toString(this._exp_)
            + toString(this._pointvirgule_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._var_ == child)
        {
            this._var_ = null;
            return;
        }

        if(this._egal_ == child)
        {
            this._egal_ = null;
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
        if(this._var_ == oldChild)
        {
            setVar((PVar) newChild);
            return;
        }

        if(this._egal_ == oldChild)
        {
            setEgal((TEgal) newChild);
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