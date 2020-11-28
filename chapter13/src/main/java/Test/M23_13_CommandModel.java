package Test;
// 命令模式关注动作本身，通过将动作封装成对象实现调用者和底层实现相分离。
// 调用者只需要简单的下达命令，然后等待命令完成即可，
// 对底层发生了什么完全不知情。
// 关于命令模式一个很直观的例子就是点餐：当我们点餐时，我们只用关心将选好的菜品下单，
// 然后等待送餐即可，我们不关心饭菜是怎么做的，不关心厨师是男是女。

public class M23_13_CommandModel {
    public static void main(String[] args) {
        Receiver receiver = new Receiver();
        Command command = new CommandImpl(receiver);
        Inverkor inverkor = new Inverkor();
        inverkor.setCommand(command);
        inverkor.execute();

    }
}

class Receiver{
    public void execute(){
        System.out.println("接收者接收到指令，并开始执行");
    }
}
abstract class Command{
    protected Receiver receiver ;
    public Command(Receiver receiver){
        this.receiver = receiver;
    }
    abstract void execute();
}
class CommandImpl extends Command{
    public CommandImpl(Receiver receiver){
        super(receiver);
    }

    @Override
    void execute() {
        this.receiver.execute();
    }
}
class Inverkor {
    private Command command ;
    public void setCommand(Command command) {
        this.command = command;
    }

    void execute(){
        this.command.execute();
    }
}
