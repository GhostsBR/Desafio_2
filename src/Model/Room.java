package Model;

public class Room {

    //Atributo ID da classe Room.
    private Integer idRoom;

    //Atributo NAME da classe Room.
    private String nameRoom;

    //Atributo CAPACITY da classe Room.
    private Integer capacityRoom;

    //Atributo QUANTITY1 da classe Room.
    private Integer quantity1 = 0;

    //Atributo QUANTITY2 da classe Room.
    private Integer quantity2 = 0;

    //Construtor vazio da classe Room.
    public Room() {};

    //Construtor com todos os parâmetros da classe Room.
    public Room(Integer idRoom, String nameRoom, Integer capacityRoom){
        this.idRoom = idRoom;
        this.nameRoom = nameRoom;
        this.capacityRoom = capacityRoom;
    }

    /**
     * Construtor com o parâmetro nameRoom e capacityRoom da classe Room
     * usado para criar entradas novas na tabela de Salas
     * Obs: estas entradas novas vão receber somente o nome e lotação da nova Sala
     * e seu idRoom será atribuído diretamente no Banco de Dados
     */
    public Room(String name, int capacity){
        this.nameRoom = name;
        this.capacityRoom = capacity;
    }

    //Método SET para atributo ID.
    public void setIdRoom(Integer idRoom){
        if (idRoom != null){
            if(idRoom>0){
                this.idRoom = idRoom;
            }else{
                System.out.println("Erro: ID da sala não pode ser negativo ou zero!");
            }
        }else {
            System.out.println("Erro: ID da sala de café não pode ser nulo!");
        }
    }

    //Método GET para o atributo ID.
    public Integer getIdRoom(){
        return this.idRoom;
    }

    //Método SET para o atributo NAME.
    public void setNameRoom(String nameRoom){
        //Verifica se o valor é nulo
        if(nameRoom!=null){
            nameRoom = nameRoom.trim();

            //Verifica se existe pelo menos 1 caracter e se não ultrapassa de 50 caracteres.
            if (nameRoom.length() > 0 && nameRoom.length() <= 50){
                //Atribui o valor ao NAME
                this.nameRoom = nameRoom;
            }else {
                System.out.println("Erro: Nome da Sala deve conter entre 1 e 50 caracteres!");
            }
        }else {
            System.out.println("Erro: Nome da Sala não pode ser nulo!");
        }
    }

    //Método GET para o valor do atributo NOME.
    public String getNameRoom(){
        return this.nameRoom;
    }

    //Método SET para o atributo CAPACITY.
    public void setCapacityRoom(Integer capacityRoom){
        //Verifica se o valor é nulo.
        if (capacityRoom!= null){
            //Verifica se o valor é menor que 1
            if(capacityRoom>0){
                this.capacityRoom = capacityRoom;
            }else {
                System.out.println("Erro: a capacidade da Sala não pode ser igual ou menor que zero!");
            }
        }else {
            System.out.println("Erro: a capacidade sa Sala não pode ser nulo!");
        }
    }

    //Mátodo de GET para o valor do atributo CAPACITY.
    public Integer getCapacityRoom(){
        return this.capacityRoom;
    }

    //Método de SET do atributo QUANTITY1.
    public void setQuantity1(Integer quantity1){
        if (quantity1 != null){
            //Verifica se o valor é menor que 1
            if (quantity1 > 0){
                this.quantity1 = quantity1;
            }else {
                System.out.println("Erro: a quantidade de pessoas na Sala não pode ser negativa!");
            }
        }else {
            System.out.println("Erro: a capacidade da Sala não pode ser nulo!");
        }
    }
    //Método do GET do atributo QUANTITY1.
    public Integer getQuantity1(){
        return this.quantity1;
    }

    //Método de SET do atributo QUANTITY2.
    public void setQuantity2(Integer quantity2){
        if (quantity2 != null){
            //Verifica se o valor é menor que 1.
            if (quantity2 > 0){
                this.quantity2 = quantity2;
            }else {
                System.out.println("Erro: a quantidade de pessoas na Sala não pode ser negativa!");
            }
        }else {
            System.out.println("Erro: a capacidade da Sala não pode ser nulo!");
        }
    }
    //Método do GET do atributo QUANTITY2.
    public Integer getQuantity2(){
        return this.quantity2;
    }

}
