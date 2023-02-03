/* This file was generated by SableCC (http://www.sablecc.org/). */

package sc.node;

import sc.analysis.*;

@SuppressWarnings("nls")
public final class APasnegationE5 extends PE5
{
    private PE6 _e6_;

    public APasnegationE5()
    {
        // Constructor
    }

    public APasnegationE5(
        @SuppressWarnings("hiding") PE6 _e6_)
    {
        // Constructor
        setE6(_e6_);

    }

    @Override
    public Object clone()
    {
        return new APasnegationE5(
            cloneNode(this._e6_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAPasnegationE5(this);
    }

    public PE6 getE6()
    {
        return this._e6_;
    }

    public void setE6(PE6 node)
    {
        if(this._e6_ != null)
        {
            this._e6_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._e6_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._e6_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._e6_ == child)
        {
            this._e6_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._e6_ == oldChild)
        {
            setE6((PE6) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
