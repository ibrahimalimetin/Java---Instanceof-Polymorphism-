/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ibrahim Ali Metin
 */
class Araba{
    
    private String model;

    public Araba(String model) {
        this.model = model;
    }

    /**
     * @return the model
     */
    public String getModel() {
        return model;
    }

    /**
     * @param model the model to set
     */
    public void setModel(String model) {
        this.model = model;
    }
    public String sur(){
        return "Araba gidiyor...";
    }
}   

    class Dizel extends Araba{

    public Dizel(String model) {
     
        super(model);// Miras aldığımız class 'ın Constructorlarını kullanmak için yazıyoruz. 
    }

    @Override
    public String sur() {
        //return super.sur(); //To change body of generated methods, choose Tools | Templates.
       return this.getModel() + " Az yakıyor...";
    }
    
    }

class YarisArabasi extends Araba{

    public YarisArabasi(String model) {
        super(model);
    }

    @Override
    public String sur() {
       // return super.sur(); //To change body of generated methods, choose Tools | Templates.
          return this.getModel() + " Hızlanıyor...";
    }
    
}

class Suv extends Araba{

    public Suv(String model) {
        super(model);
    }

    /*@Override
    public String sur() {
        //return super.sur(); //To change body of generated methods, choose Tools | Templates.
          return this.getModel() + " Tırmanıyor....";
    }*/
    
    //NOT: Alt classlarda override edilmemişse method direk kendi class fonksiyonunu çağırır. 
    
    @Override
    public String sur() {
        //return super.sur(); //To change body of generated methods, choose Tools | Templates.
          return this.getModel() + " Tırmanıyor....";
    }
}

public class Main {
    public static void surdur(Object object) { // Herhangi bir tür dönüşümü yapılmadan tek fonksiyon kullamış olduk. 
        //Bütün classlarımız objeden türemektedir. 
        //Polymorphism kullansaydık tek bir fonksiyon ile handisi olduğunu anlıyordu. Burada Object demekle hangi classtan olduğunu anlamak için kontroller yapılır. 
        //System.out.println(object.sur());
        //Polymorphism olmasaydı kodumuz kararsız ve daha fazla yazılması gerekecektir. 
        if(object instanceof Dizel){
            Dizel dizel = (Dizel) object;
            System.out.println(dizel.sur());
        }
        else if (object instanceof Suv){
            Suv suv = (Suv)object;
            System.out.println(suv.sur());
        }
        else if (object instanceof YarisArabasi){
            YarisArabasi yarisArabasi = (YarisArabasi) object;
            //yarisArabasi.sur();
        }
        else if (object instanceof Araba){
            Araba araba = (Araba) object; // Tür dönüşümü yaptık objemizi Araba 'ya dönüştürdük!!
            //araba.sur();
           
        }
    }   
    public static void main(String[] args) {
        
      //  Dizel dizel = new Dizel("Fiat Linea ");
        
      //  if (dizel instanceof Araba){ //true değerini döndürdü! dizel Araba class 'ından mıdır? sorgusudur instanceof anahtar kelimesi bir class 'ın ait olduğu class 'ı bulmak için kullanılır. 
            
        //    System.out.println("Bu nesne araba class 'ındadır...");
        
        Dizel dizel = new Dizel("Linea");
        Suv suv = new Suv("Jeep");
        YarisArabasi yarisArabasi = new YarisArabasi("BMW M5");
        Araba araba = new Araba("Focus");
        
        surdur(dizel);
        surdur(suv);
        surdur(yarisArabasi);
        surdur(araba);
    }
    }
