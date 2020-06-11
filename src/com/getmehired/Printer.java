package com.getmehired;

public class Printer<inkLevel> {

    private final int numberToPrint;
    private double inkLevel;
    private int numberOfPages;
    private int numberOfPagesPrinted;
    private int numberOfPagesLeft;
    private boolean isDoubleSided;

    public Printer(double inkLevel, int numberOfPages, int numberOfPagesPrinted, int numberOfPagesLeft,
                   boolean isDoubleSided, int numberToPrint) {

        this.numberToPrint = numberToPrint;
        /* keeping track of inkLevel percentage,here 0 being 0% & 1 being 100% */
        if (inkLevel >= 0 && inkLevel <= 1) {
            this.inkLevel = inkLevel;
        }
        this.numberOfPages = numberOfPages;
        this.numberOfPagesPrinted = numberOfPagesPrinted;
        this.numberOfPagesLeft = numberOfPagesLeft;
        this.isDoubleSided = isDoubleSided;
    }
    private <numberToPrint> boolean isOutOfInk(double numberToPrint) {
        if ((inkLevel - (numberToPrint / 2) < 0)) {
            return true;
        } else {
            return false;
        }
    }

    public void printPages(double numberToPrint) {
        if (inkLevel == 0) {
            System.out.println("Out of Ink");
        }
        if (numberOfPages == 0) {
            System.out.println("Out of Pages");
        }
        if (isOutOfInk(numberToPrint) && (inkLevel != 0)) {
            double difference = inkLevel * 2;
            numberToPrint = difference;
            numberOfPages -= numberToPrint;
            System.out.println("Will run out of toner after this print, able to print " + (int) numberToPrint +
                    " pages");
            inkLevel = 0;

        }
        if (isOutOfPages(numberToPrint) && (numberOfPages != 0)) {
            double different = numberOfPages - numberToPrint;
            numberToPrint = numberToPrint + different;
            System.out.println("Will run out of page after this print, printing " + (int) numberToPrint + " pages");
            numberOfPages = 0;
        } else if (!isOutOfInk(numberToPrint) && (!isOutOfPages(numberToPrint))) {
            numberOfPages -= numberToPrint;
            inkLevel = inkLevel - (numberToPrint / 2);
            showPages(numberToPrint);
        } else if (isDoubleSided = true) {
            if (numberToPrint % 2 == 0) {
                if (inkLevel == 0) {
                    System.out.println("Out of Ink");
                }
                if (numberOfPages == 0) {
                    System.out.println("Out of Paper");
                }
            }
        }
        public void showPages(double numberToPrint) {
            System.out.println("Printing " + (int) numberToPrint + " Pages, paper remaining is: " + this.numberOfPages
                    + " Toner level is: " + this.inkLevel);
        }
        public void refillInk(int ink) {
            inkLevel = 100;
        }
        public void refillPaper(int paper) {
            if(paper > 50) {
                System.out.println("Cannot put in more paper");
            }
            else {
                this.numberOfPages += paper;
            }
        }

    }
}

