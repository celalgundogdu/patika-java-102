package hw5_PatikaStore;

import java.util.List;

public class NotebookManager extends ProductManager<Notebook> {

    @Override
    public void printAllProducts(List<Notebook> notebookList) {
        System.out.printf("%-4s | %-30s | %-10s | %-10s | %-10s | %-5s | %-5s\n",
                "ID", "Ürün Adı", "Fiyat", "Marka", "Depolama", "Ekran", "RAM");
        System.out.println("-------------------------------------------------------------------------------------------");
        for (Notebook notebook : notebookList){
            notebook.print();
        }
    }
}
