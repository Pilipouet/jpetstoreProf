Feature: Connexions à application Jpetstore

  Scenario Outline: Connexions
    Given un navigateur est ouvert
    When je suis sur url
    And je clique sur le lien de connexion
    And rentre le Username <login>
    And rentre le Password <password>
    And je clique sur login
    Then utilisateur ABC est connecte
    And je peux lire le message accueil <message>

Examples: 
      | login    | password   | message				|
      | "j2ee"   | "j2ee"     | "Welcome ABC!"|
      | "ACID"   | "ACID"     | "Welcome ABC!"|
      