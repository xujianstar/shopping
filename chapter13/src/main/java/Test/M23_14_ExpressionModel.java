package Test;

import java.util.ArrayList;
import java.util.List;

public class M23_14_ExpressionModel {
    public static void main(String[] args) {
        SimpleExpression simpleExpression = new SimpleExpression();
        AdvanceExpression advanceExpression = new AdvanceExpression();
        Context context = new Context();
        context.setContext("解析树");
        context.add(simpleExpression);
        context.add(advanceExpression);
        List<AbstractExpression> expressionList = context.getExpressionList();

        for (AbstractExpression expression : expressionList) {
            expression.interpret(context);
        }


    }

}

abstract class AbstractExpression{
    abstract void interpret(Context ctx);
}

class SimpleExpression extends AbstractExpression {
    @Override
    void interpret(Context ctx) {
        System.out.println("这是一个简单表达式");
    }
}
class AdvanceExpression extends AbstractExpression {
    @Override
    void interpret(Context ctx) {
        System.out.println("这是高级解析器!");
    }
}


class Context{
    private List<AbstractExpression> expressionList = new ArrayList<AbstractExpression>();
    private String context ;

    public List<AbstractExpression> getExpressionList() {
        return expressionList;
    }

    public void setExpressionList(List<AbstractExpression> expressionList) {
        this.expressionList = expressionList;
    }

    public void add(AbstractExpression expression){
        expressionList.add(expression);
    }

    public List<AbstractExpression> getList(){
        return expressionList;
    }




    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }
}

