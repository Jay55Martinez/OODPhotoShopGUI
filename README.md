------------
OODPhotoshop
------------

Description:
------------
OODPhotoshop is a basic image editor that has the following features:
- Brighten/Darken
- Grayscale
- Flip Horizontal/Vertical
- Sepia
- Blur
- Sharpen
At the moment the only supported image format is PPM, JPG, PNG, and BMP.


CODE OVERVIEW:
--------------
controller:
Main - class *runs the program*
IController - Interface *contains the execute method which is run in the main*
ScriptPMMController - class *implements IController handles the parsing of the script*

Commands:
// for the command design pattern
PhotoControllerCommand - Interface *contains the execute method which runs the command on the model*
Brighten - class *implements PhotoControllerCommand*
FlipHorizontal - class *implements PhotoControllerCommand*
FlipVertical - class *implements PhotoControllerCommand*
GrayscaleComponent - class *implements PhotoControllerCommand*
Load - class *implements PhotoControllerCommand*
Save - class *implements PhotoControllerCommand*

model:
IPhotoModel - Interface *contains the methods that manipulate the image*
PPMModel - class *implements IPhotoModel contains the methods that manipulates PPM images*

Functions:
// Implements the Function class used in IPhotoModel the grayscale method
Blue - class *implements Function*
Green - class *implements Function*
Intensity - class *implements Function*
Luma - class *implements Function*
Red - class *implements Function*
Value - class *implements Function*

view:
ImageUtil - class *contains methods to load PPM files*

Changes:
- Added a pixel class to facilitate changes to the RGB values.
- Abstracted all the models since they all have the same methods.
- Added iohandler classes to handle all the IO operations (such as save and load).
- Moved the storage of images to the controller since it is the only class that needs to access it.

Image Citation:
---------------
example.ppm - image used for testing; this image was converted from png to ppm using GIMP v2.10.
“Ppm-perl6.Png.” Rosettacode.org, 25 Aug. 2022,
https://rosettacode.org/wiki/File:Ppm-perl6.png#filelinks. Accessed 2 Nov. 2022.

post.ppm - image used for testing; this image was converted from png to ppm using GIMP v2.10.
(loacated in google drive).
Ural, Kutan. Red Post Box. July 22, 2018. Unsplash.com.
https://unsplash.com/photos/yCxBGq7nuA8. Accessed November 2, 2022.

wing.jpg https://www.sample-videos.com/download-sample-jpg-image.php (50kb)

field.bmp https://filesamples.com/formats/bmp (198Kb)

beach.png https://www.sample-videos.com/download-sample-png-image.php (100kb)

