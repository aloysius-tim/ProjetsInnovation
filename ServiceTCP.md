#Protocole d'application

###Membres d'équipe
* Nikita Rousseau
* Timothy Keynes

###Services proposés
* ArrayList<Idea> getIdeas();
* ArrayList<Student> getTeam(Idea idea);
* Idea createIdea(Idea idea);
* Idea subscribeTo(Idea idea, Student student);

###Classes communes
* Request se charge de contenir les informations nécessaires au serveur pour retourner les informations demandées. 
  De ce fait, cette dernière doit être constituée du nom de la méthode a appeler ainsi que d'un tableau contenant tous les arguments à passer à cette méthode dans le même ordre.
  Cette classe est bien entendu serialisable afin de pouvoir être transmise au serveur par le client.
  Voir Javadoc pour plus de détails
  
* Une fois une requête recue, le serveur retournera une Response au client qui contiendra l'objet de retour serializé ainsi que si nécessaire un statut et un message de réussite.
  Dans le cas d’une erreur, l’Exception sera présente dans la variable « value ».
  Voir Javadoc pour plus de détails
  
###Remarques
* ObjectInputStream et ObjectOutputStream devront être utilisés afin de communiquer efficacement avec notre serveur.
* Les classes communes au serveur et au client sont fournis en parralèle au format .class et décrits sous forme de javadoc.
* Cette implémentation n'est pas persistante et ne conserve donc pas les données après "extinction".
