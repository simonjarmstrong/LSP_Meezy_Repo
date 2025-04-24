package org.howard.edu.lspfinal.question3;

/**
 * Abstract base class representing a report generation process.
 * Implements the Template Method design pattern.
 */
public abstract class Report {

    public final void executeReportWorkflow() {
        retrieveData();
        processFormatting();
        displayReport();
    }

    
    protected abstract void retrieveData();
    protected abstract void processFormatting();
    protected abstract void displayReport();
}
