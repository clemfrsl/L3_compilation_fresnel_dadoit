package sa;
import util.Type;

public class SaExpMult implements SaExp{
    private SaExp op1;
    private SaExp op2;

    public SaExpMult(SaExp op1, SaExp op2){
	this.op1 = op1;
	this.op2 = op2;
    }

    public SaExp getOp1(){return this.op1;}
    public SaExp getOp2(){return this.op2;}
    
    public Type getType(){
	return Type.ENTIER;
    }
    public <T> T accept(SaVisitor <T> visitor) throws Exception{
        return visitor.visit(this);
    }
}
