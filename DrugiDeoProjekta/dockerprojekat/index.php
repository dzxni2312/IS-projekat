<?php
 if (isset($_GET['ckid'])) {
 $outcome=rand(0,200);
 if($outcome>100)
	echo "Potreban potpis";
 else
	echo "Nije potreban potpis";
 }else{
	echo "Transakcija id nije dobra";	
 }
?>