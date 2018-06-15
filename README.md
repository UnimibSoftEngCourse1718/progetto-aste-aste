# **Progetto-aste-aste**

Portale di aste online

## **Pre-Requisiti**

- Eclipse J2EE : http://www.eclipse.org/downloads/packages/eclipse-ide-java-ee-developers/oxygen3a
- Maven : https://maven.apache.org/download.cgi
- Tomcat v9.0 : [https://tomcat.apache.org/download-90.cgi](https://tomcat.apache.org/download-90.cgi)
- MySql : [https://dev.mysql.com/downloads/installer/](https://dev.mysql.com/downloads/installer/)
- Java 8 : http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html

## **Installazione componenti**

Scaricare zip del progetto, scompattarlo e importarlo su eclipse: File &gt; Open Project from File System. Selezionare il progetto scaricato e al termine cliccare su Finish.

- Installazione Server Tomcat:

1. Aprire la vista server : Window &gt; Show View &gt; Servers
2. Click su link &quot;create a new server..&quot;
3. Aprire cartella Apache e selezionare Tomcat v9.0 Server e cliccare Next
4. Aprire il server scaricato tramite bottone &quot;Browse..&quot; e selezionare la JRE 1.8
5. Cliccare su Finish

Installare tutti i componenti di MySql

- Configurazione MySql Server

1. Group Replication: Standalone MySql Server
2. Type Networking lasciare configurazione di default
3. Authentication Method: Use Legacy Authentication Method
4. Accounts and Role: Password -&gt; admin123
5. Windows Service lasciare configurazione di default
6. Plugins and Extensions lasciare configurazione di default
7. Applicare le configurazione scelte

- Creazione Schema database

1. Aprire MySql Workbench
2. Aprire l&#39;istanza già presente inserendo la passeord -&gt; admin1234
3. Data Import/Restore
4. Selezionare Import from Self-Contained File e aprire file aste.sql dal progetto
5. Start Import
6. Refresh su Schema

## **Build**

Per effettuare la build:

1. Click tasto desto sul progetto aste da Eclipse -&gt; Maven &gt; Update Project..
2. Selezionare il progetto aste e check su Force Update poi premere ok
3. Click tasto desto sul progetto aste da Eclipse -&gt; Run As.. &gt; Maven build..
4. Nel field Goals scrivere &quot;clean install&quot;.
5. Inserire Name della build (Facoltativo)
6. Premere su Apply
7. Premere su Run

## **Deploy**

Per effettuare il deploy:

1. Click tasto destro sul progetto aste da Eclipse -&gt; Run As.. &gt; Run On Server
2. Premere Next
3. Se il progetto è già presente nella colonna &quot;Configured:&quot; premere Finish altrimenti premere Add &gt; e poi Finish
4. In caso di errore in lettura sulle dipendenze maven cancellare tutto il contenuto della cartella repository di maven
