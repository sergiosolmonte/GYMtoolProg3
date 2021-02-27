package com.gymtool.myProgram;

import com.gymtool.dao.DaoAllenamento;
import com.gymtool.dao.DaoEsercizi;
import com.gymtool.dao.DaoScheda;
import com.gymtool.model.Allenamento;
import com.gymtool.model.Esercizio;
import com.gymtool.model.Scheda;
import java.sql.SQLException;
import java.util.*;

/**
 * Classe myProgram che implementa i metodi astratti della classe myP
 * I metodi verranno spiegati in basso.
 */

public class MyProgram extends myP{

    private final double epsilon = 0.01;
    private int iteration;
    private final int nRow;
    private final int nCol;
    private double Vscheda;
    private final double myValue;
    private ArrayList<Integer> myProgram;
    private HashMap<Integer, Double> myHash;
    private ArrayList<Optional<Esercizio>> myEx;


    /**
     * Costruttore della classe, setta le variabili prese da
     * @param choose, che sarebbero quelli risultanti dal survey,
     * Attraverso l'uso di una costante e del valore medio di Giorni e Allenamenti
     * giornalieri, restituisce un valore che rappresenta il valore che voglio raggiungere
     * con la mia scheda.
     */
    public MyProgram(ArrayList<Integer> choose){

        nRow= choose.get(0);
        nCol = choose.get(1);
        double rappAureo=1.61803398874989484820458683436563811;
        myValue = ((nCol + nRow) / 2) * ((((choose.get(2) * rappAureo) + (choose.get(3) * rappAureo)) - (choose.get(4) * rappAureo)) + (choose.get(5) * rappAureo));


    }

    /**
     * Metodo che assegna i valori iniziali :
     * all'HasMap contenente idEsercizio e valore esercizi;
     * inizializza il numero di iterazioni che compie nel tentativo di migliorare il valore della scheda;
     *
     */
     public void Assign_initial_value() {
        iteration=0;
        Vscheda=0.0;
        myHash = new HashMap<>();
        myProgram=new ArrayList<>();

        DaoEsercizi edao = new DaoEsercizi();

        try {
             myEx= edao.getAll("Esercizio");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        Random r = new Random();

        int len = myEx.size();
        for(int i=0;i<len;i++){
            double randomValue;
            if(myValue>100)
                randomValue = 1.1 + (8.0 - 1.1) * r.nextDouble();
            else if(myValue<=100 && myValue>85)
                randomValue = 1.8 + (9.3 - 1.8) * r.nextDouble();
            else if (myValue <=85 && myValue>65)
                 randomValue = 2.0 + (9.7 - 2.0) * r.nextDouble();
            else if (myValue <=65 && myValue>40)
                 randomValue = 2.3 + (10.1 - 2.3) * r.nextDouble();
            else
                 randomValue = 2.5 + (10.5 - 2.5) * r.nextDouble();

            myHash.put(i,randomValue);
        }

    }

    /**
     * Questo metodo somma i valori degli esercizi
     * contenuti nel programma di allenamento e va ad aggiornare il valore.
     */
    private void getValueScheda(){

        Vscheda=0.0;
        for (Integer integer : myProgram) {
            Vscheda += myHash.get(integer);
        }
    }

    /**
     * Metodo che inizializza la scheda allenamento con esercizi randomici.
     */
    public void getRandomProgram() {

        Random r = new Random();
        int numEsercizi = nCol*nRow;
        for (int i=0;i<numEsercizi;i++){
            int randomInteger = r.nextInt(myEx.size()-1);

            if(randomInteger==0 ){
                myProgram.add(randomInteger);
                Vscheda+=myHash.get(randomInteger);
            }
            else{
                myProgram.add(randomInteger);
                Vscheda+=myHash.get(randomInteger);
            }

        }


    }

    /**
     * Metodo cardine dell'algoritmo che aggiorna la scheda elimando sempre l'esercizio con il valore massimo
     * e va a sostituire con l'esercizio casuale con valore inferiore al suo (non il minimo), controllando che quell'esercizio
     * non sia presente nell'intorno 2x2
     */
    public void updateProgram() {

        Double max= myHash.get(myProgram.get(0));
        int key = 0;

        for(int i=1;i<myProgram.size();i++){
            if (myHash.get(myProgram.get(i))>max){
                max=myHash.get(myProgram.get(i));
                key = i;
            }
        }
        Random r = new Random();

        double newValue=999.999;
        int newValueIndex = 0;
        boolean flag;
        while(newValue>max){
            flag=true;
            int randomInteger = r.nextInt(myHash.size()-1);
            if(key+2 < myProgram.size()){
                if (randomInteger == myProgram.get(key+1)) {
                    flag = false;
                }
                if (randomInteger == myProgram.get(key+2)) {
                    flag = false;
                }
            }

            if( key-2 > 0){
                if (randomInteger == myProgram.get(key-1)) {
                    flag = false;
                }
                if (randomInteger == myProgram.get(key-2)) {
                    flag = false;
                }
            }

            if (flag){
                newValueIndex=randomInteger;
                newValue=myHash.get(randomInteger);
            }


        }
        myProgram.set(key,newValueIndex);


        }

    /**
     * Metodo che salva la scheda nel DB tramite il DAOscheda
     * @param idUtente rappresenta l'id dell'utente a cui aggiungere la scheda
     */
    private void salva_scheda(int idUtente){
        Scheda scheda = new Scheda();
        DaoScheda sDao = new DaoScheda();

        int idScheda=0;

        try {
            idScheda = sDao.getCount(idUtente);
            System.out.println("IDSCHEDA: "+ idScheda);

        } catch (NoSuchElementException ignored) {

        }catch (SQLException throwables){
            throwables.printStackTrace();
        }

        idScheda+=1;
        String title = "Scheda generata automaticamente #"+idScheda;
        scheda.setIdUtente(idUtente);
        scheda.setNome(title);
        scheda.setShare(false);


        try {
            sDao.Add(scheda);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }



        try {
            idScheda = sDao.getLast(idUtente).get().getID();


            DaoAllenamento aDao =new DaoAllenamento();
            Allenamento a = new Allenamento();
            Random r = new Random();

            for(int i=0;i<nRow;i++){
                for(int j=0;j <nCol; j++){
                    a.setIDscheda(idScheda);
                    a.setIDesercizio((myProgram.get((i*nCol)+j))+1);
                    a.setSerie(r.nextInt(3)+3);
                    a.setRipetizioni(r.nextInt(16)+4);
                    a.setTempo(r.nextInt(5)+3);
                    a.setGiorno(i);
                    a.setNumero(j);
                    aDao.Add(a);
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }


    /**
     * Metodo che implementa tutti gli altri, richiamato dalla action dell'EditorPro
     * @param IdUtente rappresenta l'idUtente passato in input
     * @return l'arrayList di interi contenete gli IDesercizi appena calcolato.
     */
    public ArrayList<Integer> doAutomaticProgram(int IdUtente){

        Assign_initial_value();
        getRandomProgram();
        do{
            iteration++;
            updateProgram();
            getValueScheda();

        }while ( ((Vscheda - myValue )> epsilon) && iteration<100) ;


        salva_scheda(IdUtente);
        System.out.println("----------------------Iterazioni-------------------------: "+iteration);

        return myProgram;
    }


}
