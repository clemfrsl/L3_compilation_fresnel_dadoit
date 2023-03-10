/* This file was generated by SableCC (http://www.sablecc.org/). */

package sc.node;

import sc.analysis.*;

@SuppressWarnings("nls")
public final class APasegalinfE2 extends PE2
{
    private PE3 _e3_;

    public APasegalinfE2()
    {
        // Constructor
    }

    public APasegalinfE2(
        @SuppressWarnings("hiding") PE3 _e3_)
    {
        // Constructor
        setE3(_e3_);

    }

    @Override
    public Object clone()
    {
        return new APasegalinfE2(
            cloneNode(this._e3_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAPasegalinfE2(this);
    }

    public PE3 getE3()
    {
        return this._e3_;
    }

    public void setE3(PE3 node)
    {
        if(this._e3_ != null)
        {
            this._e3_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._e3_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._e3_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._e3_ == child)
        {
            this._e3_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._e3_ == oldChild)
        {
            setE3((PE3) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
