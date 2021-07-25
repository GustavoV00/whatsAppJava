package command;

public class ExcluirMensagem implements Command{

    @Override
    public void executarComando(){
        System.out.println("Excluir mensagem!\n");
    }
    
}
