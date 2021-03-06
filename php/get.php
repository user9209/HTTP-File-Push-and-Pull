<?php

/*
    Auth with Secret
    Last file will downloaded
    Static name: "data.raw"
*/

include_once('./data/.auth.get.php');

if (!isset($secrets) || sizeof($secrets) === 0)
  die("no auth users!");

if(!isset($_GET['auth']) || !in_array($_GET['auth'],$secrets, true))
  die("no auth!");

$old_file_array = scandir ( "./data/", SCANDIR_SORT_DESCENDING);


// skip ".", ".." und ".htaccess"
if($old_file_array && sizeof($old_file_array) > 3)
  $file = $old_file_array[0];
else
  die("no files available!");

$uploaddir = './data/';

makeDownloadNamed($file, $uploaddir, "data.raw", "application/octet-stream");

function makeDownloadNamed($file, $dir, $downdoadFileName, $type) {
    header("Content-Type: $type");
    header("Content-Disposition: attachment; filename=\"$downdoadFileName\"");
    readfile($dir.$file);
}

?>

