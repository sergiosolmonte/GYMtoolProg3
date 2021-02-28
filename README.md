# GYMtool
Progetto realizzato per l'esame di Programmazione 3 dell'Università Parthenope
Per utilizzare GYMtool è necessario:
1. Scaricare il codice come .zip 
2. Avviare un'IDE per un progetto java (per l'esempio è stato utilizzato IntelliJ IDEA)  e aprire il **progetto** GYMtool contenuto nella cartella scaricata
3. Seguire i seguenti passi ed avviare l'esecuzione.

Quando meaven richiederà il download delle dipendenze, selezionare always download (o download once)

Al termine dello scaricamento delle dipendenze, sarà possibile configurare l’SDK e  il web-server su cui far girare il progetto (nel nostro caso è stato utilizzato Glassfish5)

Installazione SDK
Clicciamo su File -> Project Structure come in figura
<img src="https://github.com/sergiosolmonte/GYMtoolProg3/blob/main/projectStructure.PNG?raw=true" width="500" height="400"/>

Notiamo che non c’è nessun SDK installato sulla nostra macchina attuale
<img src="https://github.com/sergiosolmonte/GYMtoolProg3/blob/main/noSDK.PNG?raw=true" width="500" height="400"/>


Recarsi alla pagina :
https://www.oracle.com/it/java/technologies/javase/javase-jdk8-downloads.html
e scaricare la versione corretta per la macchina in uso.
Procedere con l'esecuzione e segnarsi la direcotry di installazione.

Nel caso in cui siate già in possesso di SDK
Basterà aggiungerlo al progetto o selezionarlo nel menù a tendina.

Procedere come in figura con l’aggiunta:
aggiungiSDK.png

Dopo averlo aggiunto, fare applica e OK.
sdkAggiunto.png

Concedere nuovamente i download nella finestra pop-up in basso a destra ed attendere il completamento delle operazioni.


Ora passiamo al web-server locale, abbiamo utilizzato GLassfish5.0.1

https://javaee.github.io/glassfish/download

Selezionare la versione più recente, anche in formato web profile e successivamente seguire il README.txt presente nell’archivio per l’istallazione su WIndows e UNIX.

Successivamente procedere con l’aggiunta di una configurazione:
addConf.png

Selezionare il + ed aggiungere un GlassFishServer Local
selectGlass.png

Procediamo con la configurazione, configurando Application Server, impostando come glassfish Home la directory estratta dal file .zip di GlassFish nell’’ultima versione la direcotry si chiama GlassFish5)
AggiuntaGlassDirectory.png

Se sono state seguite le istruzioni sul readMe di glassfish, il domain dovrebbe già essere attivo e bisogna solo selezionarlo:
serverdomain.png

Poi è necessario configurare il JRE , che inizialmente sarà su default:
JREDefault.png

Basterà aprire il menù a tendina e selezionare “1.8” che sarebbe quello dell’SDK aggiunto poco fa.:
JRE1.8.png

Infine l’ultimo passo è quello di creare un artifact per l’esecuzione. Verrà notificata la sua assenza nella parte bassa di questo menu di configurazione, con IntelliJ sarà necessario cliccare su FIX e scegliere GYMtool war : exploded
selectArtifact.png

Se non viene notificato, recarsi nella finestra deployment, aggiungere artifact war: exploded come in figura:
addArtifact

//C’è la possibilità che si presenti un errore “Debug Configuration Invalid”, sarà necessario //selezionare il tasto FIX come fatto in precedenza per risolvere il problema

Salvare il tutto con apply e OK. Notiamo la configurazione in alto a destra.

Come ultimo passaggio è necessario installare un server Database. 
Noi abbiamo utilizzato MariaDB. Il tutorial dell’installazione è presente sul sito ufficiale.
Per utilizzare un DB server con GYMtool è necessario modificare le impostazioni presenti sul file “DB.java” in modo da accedre correttamente al database utilizzando il connettore giusto.

Per un primo ed efficace test è presente il DUMP del nostro database in formato SQL (DumpDB1.sql) che basterà eseguirlo in un qualsiasi strumento di amministrazione di database (HEIDIsql, SQLworkbench ..) per poter usufruire delle funzionalità dell’applicazione.










**Per il correto funzionamento del CDN occorre essere conessi alla rete.
