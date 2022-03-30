<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="no">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <link rel="icon" href="data:," />
    <link href="stylesheet.css" rel="stylesheet" type="text/css" />
    <script src = ./JavaScript/FormControl.js>></script>
    <title>Påmelding</title>
  </head>
  <body>
    <h2>Påmelding</h2>    

      <form method="post" action="Registration">
        <fieldset>
          <label for="username">Brukernavn:</label>
          <input type="text" name="username" id="username" value=""
               placeholder="Fyll inn brukernavn"
               title="Fornavn må starte med stor forbokstav og innholde kun bokstaver. Antall tegn må være mellom 2 og 20."
           />
          <span class="melding">Ugyldig brukernavn</span>
<!-- 
          <label for="fullname">Fult navn:</label>
          <input type="text" name="fullname" id="fullname" value=""
               placeholder="Fyll inn fult navn"
               title="Etternavn må starte med stor forbokstav og innholde kun bokstaver. Antall tegn må være mellom 2 og 20."
           />
          <span class="melding">Ugyldig navn</span>

          <label for="mobil">Email:</label>
          <input type="text" name="email" id="email" value=""
              placeholder="Fyll inn email"
              title="fyll inn email"
           />
          <span class="melding">Ugyldig mail adresse</span>

          <label for="passord">Passord:</label>
          <input type="password" name="password" id="passord" value=""
              placeholder="Velg et passord"
              title="Passordet må bestå av minst 8 tegn, men bør ha minst 14 tegn."
              required pattern=".{8,}"
           />
         <span class="melding">Ugyldig passord</span>

          <label for="passordRepetert">Passord repetert:</label>
          <input type="password" name="password2" id="passordRepetert" value=""
              placeholder="Gjenta passord"
              required  />
          <span class="melding">Passordene må være like</span> -->

          <button type="submit">Registrer deg</button>
        </fieldset>
      </form>
      
      <form action="player" method="post">
      	<label>Hent spiller med ID</label>
      	<input type="number" name="idnumber" id="idnumber">
      	<button type="submit">Hent spiller</button>
      </form>
      <p> spillerens navn </p>
      <p> ${Player.username}</p>
      
      <p>Hvis du allerede er registrert kan du logge inn her:
      <form action="login" method="get">
      	<button type="submit">logg inn</button>
      </form>
  </body>
</html>
