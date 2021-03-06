import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

/**
 * A class that represents a picture.  This class inherits from 
 * SimplePicture and allows the student to add functionality to
 * the Picture class.  
 * 
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture 
{
    ///////////////////// constructors //////////////////////////////////

    /**
     * Constructor that takes no arguments 
     */
    public Picture ()
    {
        /* not needed but use it to show students the implicit call to super()
         * child constructors always call a parent constructor 
         */
        super();  
    }

    /**
     * Constructor that takes a file name and creates the picture 
     * @param fileName the name of the file to create the picture from
     */
    public Picture(String fileName)
    {
        // let the parent class handle this fileName
        super(fileName);
    }

    /**
     * Constructor that takes the width and height
     * @param height the height of the desired picture
     * @param width the width of the desired picture
     */
    public Picture(int height, int width)
    {
        // let the parent class handle this width and height
        super(width,height);
    }

    /**
     * Constructor that takes a picture and creates a 
     * copy of that picture
     * @param copyPicture the picture to copy
     */
    public Picture(Picture copyPicture)
    {
        // let the parent class do the copy
        super(copyPicture);
    }

    /**
     * Constructor that takes a buffered image
     * @param image the buffered image to use
     */
    public Picture(BufferedImage image)
    {
        super(image);
    }

    ////////////////////// methods ///////////////////////////////////////

    /**
     * Method to return a string with information about this picture.
     * @return a string with information about the picture such as fileName,
     * height and width.
     */
    public String toString()
    {
        String output = "Picture, filename " + getFileName() + 
            " height " + getHeight() 
            + " width " + getWidth();
        return output;

    }

    /** Method to set the blue to 0 */
    public void zeroBlue()
    {
        Pixel[][] pixels = this.getPixels2D();
        for (Pixel[] rowArray : pixels)
        {
            for (Pixel pixelObj : rowArray)
            {
                pixelObj.setBlue(0);
            }
        }
    }

    /** Method that mirrors the picture around a 
     * vertical mirror in the center of the picture
     * from left to right */
    public void mirrorVertical()
    {
        Pixel[][] pixels = this.getPixels2D();
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        int width = pixels[0].length;
        for (int row = 0; row < pixels.length; row++)
        {
            for (int col = 0; col < width / 2; col++)
            {
                leftPixel = pixels[row][col];
                rightPixel = pixels[row][width - 1 - col];
                rightPixel.setColor(leftPixel.getColor());
            }
        } 
    }

    public void mirrorVerticalRightToLeft()
    {
        Pixel[][] pixels = this.getPixels2D();
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        int width = pixels[0].length;
        for (int row = 0; row < pixels.length; row++)
        {
            for (int col = 0; col < width / 2; col++)
            {
                leftPixel = pixels[row][col];
                rightPixel = pixels[row][width - 1 - col];
                leftPixel.setColor(rightPixel.getColor());
            }
        } 
    } 

    public void mirrorHorizontal()
    {
        Pixel[][] pixels = this.getPixels2D();
        Pixel topPixel = null;
        Pixel bottomPixel = null;
        int width = pixels[0].length;
        int rows = pixels.length;
        for (int row = 0; row < rows/2; row++)
        {
            for (int col = 0; col < width; col++)
            {
                topPixel = pixels[row][col];
                bottomPixel = pixels[rows-row-1][col];
                bottomPixel.setColor(topPixel.getColor());
            }
        } 
    } 

    public void mirrorHorizontalBotToTop()
    {
        Pixel[][] pixels = this.getPixels2D();
        Pixel topPixel = null;
        Pixel bottomPixel = null;
        int width = pixels[0].length;
        int rows = pixels.length;
        for (int row = 0; row < rows/2; row++)
        {
            for (int col = 0; col < width ; col++)
            {
                topPixel = pixels[row][col];
                bottomPixel = pixels[rows-row-1][col];
                topPixel.setColor(bottomPixel.getColor());
            }
        } 
    } 

    public void mirrorDiagonal()
    {
        Pixel[][] pixels = this.getPixels2D();
        Pixel origPixel = null;
        Pixel copyPixel = null;
        int width = pixels[0].length;
        int rows = pixels.length;

        int smallerSide= 0;
        if(rows>width)
        {
            smallerSide = width;
        }
        else 
        {
            smallerSide = rows;
        }

        for (int row = 0; row < smallerSide; row++)
        {
            for (int col = 0; col < smallerSide ; col++)
            {
                origPixel = pixels[row][col];
                copyPixel = pixels[col][row];
                origPixel.setColor(copyPixel.getColor());
            }
        } 
    } 

    public void mirrorDiagonalNOTRighy()
    {
        Pixel[][] pixels = this.getPixels2D();
        Pixel topRightPixel = null;
        Pixel bottomLeftPixel = null;
        int width = pixels[0].length;
        int rows = pixels.length;
        double diagonal= rows*Math.pow(2,1/2);
        for (int row = 0; row< diagonal; row++)
        {
            for (int col = 0; col < diagonal ; col++)
            {

                topRightPixel = pixels[row][width-col-1];
                bottomLeftPixel = pixels[rows-row-1][col];
                bottomLeftPixel.setColor(topRightPixel.getColor());
            }
        } 
    } 

    /** Mirror just part of a picture of a temple */
    public void mirrorTemple()
    {
        int mirrorPoint = 276;
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        int count = 0;
        Pixel[][] pixels = this.getPixels2D();

        // loop through the rows
        for (int row = 27; row < 97; row++)
        {
            // loop from 13 to just before the mirror point
            for (int col = 13; col < mirrorPoint; col++)
            {
                count ++;
                leftPixel = pixels[row][col];      
                rightPixel = pixels[row]                       
                [mirrorPoint - col + mirrorPoint];
                rightPixel.setColor(leftPixel.getColor());
            }
        }
        //return count;
    }

    public void mirrorArms()
    {
        int mirrorPoint = 204;
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        int count = 0;
        Pixel[][] pixels = this.getPixels2D();

        // loop through the rows
        for (int row = 156; row < 194; row++)
        {
            // loop from 13 to just before the mirror point
            for (int col = 102; col < mirrorPoint; col++)
            {

                leftPixel = pixels[row][col];      
                rightPixel = pixels[row]                       
                [mirrorPoint - col + mirrorPoint];
                rightPixel.setColor(leftPixel.getColor());
            }
        }

    }

    public void mirrorGull() 
    {
        int mirrorPoint = 257;
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        int count = 0;
        Pixel[][] pixels = this.getPixels2D();

        // loop through the rows
        for (int row = 0; row < 194; row++)
        {
            // loop from 13 to just before the mirror point
            for (int col = 255; col < mirrorPoint; col++)
            {

                leftPixel = pixels[row][col];      
                rightPixel = pixels[row]                       
                [mirrorPoint - col + mirrorPoint];
                rightPixel.setColor(leftPixel.getColor());
            }
        }

    }

    public void keepOnlyBlue()
    {
        Pixel[][] pixels = this.getPixels2D();
        for (Pixel[] rowArray : pixels)
        {
            for (Pixel pixelObj : rowArray)
            {
                pixelObj.setRed(0);
                pixelObj.setGreen(0);
            }
        }
    }

    public void negate()
    {
        Pixel[][] pixels = this.getPixels2D();
        for (Pixel[] rowArray : pixels)
        {
            for (Pixel pixelObj : rowArray)
            {
                pixelObj.setRed(255-pixelObj.getRed());
                pixelObj.setGreen(255-pixelObj.getGreen());
                pixelObj.setBlue(255-pixelObj.getBlue());
            }
        }
    }

    public void fixUnderwater()
    {
        Pixel[][] pixels = this.getPixels2D();
        for (Pixel[] rowArray : pixels)
        {
            for (Pixel pixelObj : rowArray)
            {
                pixelObj.setRed(200);
                pixelObj.setGreen(0);
                pixelObj.setBlue(0);
            }
        }
    }

    public void grayScale()
    {
        Pixel[][] pixels = this.getPixels2D();
        int average = 0; 
        for (Pixel[] rowArray : pixels)
        {
            for (Pixel pixelObj : rowArray)
            {
                average =(pixelObj.getRed() +pixelObj.getBlue()+pixelObj.getGreen())/3;

                pixelObj.setRed(average);
                pixelObj.setGreen(average);
                pixelObj.setBlue(average);
            }
        }
    }

    /** copy from the passed fromPic to the
     * specified startRow and startCol in the
     * current picture
     * @param fromPic the picture to copy from
     * @param startRow the start row to copy to
     * @param startCol the start col to copy to
     */
    public void copy(Picture fromPic, 
    int startRow, int startCol)
    {
        Pixel fromPixel = null;
        Pixel toPixel = null;
        Pixel[][] toPixels = this.getPixels2D();
        Pixel[][] fromPixels = fromPic.getPixels2D();
        for (int fromRow = 0, toRow = startRow; 
        fromRow < fromPixels.length &&
        toRow < toPixels.length; 
        fromRow++, toRow++)
        {
            for (int fromCol = 0, toCol = startCol; 
            fromCol < fromPixels[0].length &&
            toCol < toPixels[0].length;  
            fromCol++, toCol++)
            {
                fromPixel = fromPixels[fromRow][fromCol];
                toPixel = toPixels[toRow][toCol];
                toPixel.setColor(fromPixel.getColor());
            }
        }   
    }

    /**making a picture that you can cut and copy
     * @param fromPic the picture to copy from
     * @param startRow the start row to copy to
     * @param startCol the start col to copy to*/
    public void cropAndCopy( Picture sourcePicture, int startSourceRow, int endSourceRow, int startSourceCol, int endSourceCol,
    int startDestRow, int startDestCol )
    {
        Pixel fromPixel = null;
        Pixel toPixel = null;
        Pixel[][] toPixels = this.getPixels2D();
        Pixel[][] fromPixels = sourcePicture.getPixels2D();
        for (int fromRow = startSourceRow, toRow = startDestRow; 
        fromRow < endSourceRow &&
        toRow < toPixels.length; 
        fromRow++, toRow++)
        {
            for (int fromCol = startSourceCol, toCol = startDestCol; 
            fromCol < endSourceCol&&
            toCol < toPixels[0].length;  
            fromCol++, toCol++)
            {
                fromPixel = fromPixels[fromRow][fromCol];
                toPixel = toPixels[toRow][toCol];
                toPixel.setColor(fromPixel.getColor());
            }
        }    
    }

    /** Method to create a collage of several pictures */
    //     public void createCollage()
    //     {
    //         Picture flower1 = new Picture("flower1.jpg");
    //         Picture flower2 = new Picture("flower2.jpg");
    //         this.copy(flower1,0,0);
    //         this.copy(flower2,100,0);
    //         this.copy(flower1,200,0);
    //         Picture flowerNoBlue = new Picture(flower2);
    //         flowerNoBlue.zeroBlue();
    //         this.copy(flowerNoBlue,300,0);
    //         this.copy(flower1,400,0);
    //         this.copy(flower2,500,0);
    //         this.mirrorVertical();
    //         this.write("collage.jpg");
    //     }

    /**
    */
    public void createCollage()
    {
        //making all the eyes
        Picture eye = new Picture("download.jpg");
        Picture eye2 = new Picture("download.jpg");
        Picture eye3 = new Picture("download.jpg");
        Picture eye4 = new Picture("download.jpg");
        Picture eye5 = new Picture("download.jpg");
        this.scaleByHalf();
        eye.grayScale();
        eye.mirrorVertical();
        eye2.mirrorDiagonalNOTRighy();
        eye2.mirrorVertical();
        this.copy(eye,0,0);
        this.copy(eye2,0,256);
        Picture scaryEye = new Picture(eye3);
        Picture scaryEye2 = new Picture(eye4);
        scaryEye.negate();
        scaryEye.mirrorVertical();
        this.copy(scaryEye,195,256);
        scaryEye2.negate();
        scaryEye2.mirrorVertical();
        this.copy(scaryEye2,195,0);
        this.mirrorHorizontal();
        Picture scaryEye3 = new Picture(eye5);
        scaryEye2.mirrorVertical();
        scaryEye3.negate();
        scaryEye3.mirrorVertical();
        scaryEye3.mirrorHorizontal();
        this.cropAndCopy(scaryEye3,85,115,115,145,196,239);//top
        this.cropAndCopy(scaryEye3,85,115,115,145,227,239);//middle
        this.cropAndCopy(scaryEye3,85,115,115,145,227,269);//right
        this.cropAndCopy(scaryEye3,85,115,115,145,227,208);//left
        this.cropAndCopy(scaryEye3,85,115,115,145,256,239);//bottom
        this.cropAndCopy(scaryEye3,85,115,115,145,196,270);//top right
        this.cropAndCopy(scaryEye3,85,115,115,145,196,206);//top left
        this.cropAndCopy(scaryEye3,85,115,115,145,256,269);//bot right
        this.cropAndCopy(scaryEye3,85,115,115,145,256,208);//bot left
        this.write("Eyes.jpg");
    }

    public Picture scaleByHalf()
    {
        Pixel fromPixel = null;
        Picture eye = new Picture("download.jpg");
        Pixel[][] fromPixels = this.getPixels2D();
        int height = fromPixels.length;
        int width = fromPixels[0].length;
        int newHeight = fromPixels.length/2;
        int newWidth = fromPixels[0].length/2;
        return eye;
    }

    /** Method to show large changes in color 
     * @param edgeDist the distance for finding edges
     */
    public void edgeDetection(int edgeDist)
    {
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        Pixel[][] pixels = this.getPixels2D();
        Color rightColor = null;
        for (int row = 0; row < pixels.length; row++)
        {
            for (int col = 0; 
            col < pixels[0].length-1; col++)
            {
                leftPixel = pixels[row][col];
                rightPixel = pixels[row][col+1];
                rightColor = rightPixel.getColor();
                if (leftPixel.colorDistance(rightColor) > 
                edgeDist)
                    leftPixel.setColor(Color.BLACK);
                else
                    leftPixel.setColor(Color.WHITE);
            }
        }
    }

    /* Main method for testing - each class in Java can have a main 
     * method 
     */
    public static void main(String[] args) 
    {
        Picture beach = new Picture("beach.jpg");
        beach.explore();
        beach.zeroBlue();
        beach.explore();
    }

} // this } is the end of class Picture, put all new methods before this
