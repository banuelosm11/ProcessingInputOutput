# ProcessingInputOutput

Write a `ZIPEnumerator` utility that searches a directory 
(specified in the constructor) and all subdirectories 
for zip files.

Provide a function that returns a list Path objects to 
all zip files found

ZIPEnumerator should have a constructor flag that sets 
whether it also lists jar files.

provide another function that lists only the names 
of all of the files found

Add a method to the `ZipEnumerator` to add a file 
to a selected ZIP archive. This should accept either 
a Path to the zip (within the directory structure 
searched by this instance) or the name of the file. If the name 
(as a string) is not unique throw an 
`AmbiguousFileNameException`. Include an optional parameter 
for the path within the ZIP to write the file; if it is not 
specified then write the file to `/` within the ZIP filesystem.

