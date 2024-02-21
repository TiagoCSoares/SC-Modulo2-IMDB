package org.example.view;

public class Menu extends AbstractMenuView{

    private Object obj;

    public Menu(Object obj) {
        super(new String[]{
                "1 - Filmes",
                "2 - Artistas",
                "3 - Diretores",
                "0 - Sair"
        });
        this.obj = obj;
    }

    @Override
    protected Boolean validOption(Integer option) {
        return option >= 0 && option <= 3;
    }

    @Override
    protected void executeOption(Integer option) {
        switch (option) {
            case 0 -> System.exit(1);
            default -> System.out.println("Opcao não disponível");
        }
        execute();
    }
}
