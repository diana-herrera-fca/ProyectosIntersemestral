## ------------EJERCICIO: Bill Division ----------------------

````
class Result {

/*
* Complete the 'bonAppetit' function below.
*
* The function accepts following parameters:
* 1. INTEGER_ARRAY bill
* 2. INTEGER k
* 3. INTEGER b
*/

public static void bonAppetit(List<Integer>bill, int k, int b, int n) {
// Write your code here
int dineroDeber =0;
int sumaTotal=0;
int pagoAna=0;
//n = numero de articulos que ordenaron
//k = El numero de posicion del articulo que ana no consumio

for (int i=0; i<n; i++){
    sumaTotal = sumaTotal + bill.get(i);

} 

pagoAna = (sumaTotal - bill.get(k)) /2;




if (pagoAna == b){
System.out.println("Bon Appetit");
}

else {
System.out.println(b-pagoAna);
}

}
}

````