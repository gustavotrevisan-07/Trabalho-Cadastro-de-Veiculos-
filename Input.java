public class Input {
    public int readInt(String message){
        while(true){
            try{
                String valor = IO.readln(message);
                return Integer.parseInt(valor);

            } catch (Exception e){
                System.out.println("Valor inválido, tente novamente.");
            }
        }
    }
}