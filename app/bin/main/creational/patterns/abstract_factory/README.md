# Overview

## In this design pattern, I tried simulate real scenario in a Financial Institution.

I used Abstract Factory to resolve a problem, where I needed generate positional files with different layouts for each bank.

Positional files are still use for information exchange.

## Implementation

I created the class PaymentsFileGenerator that is responsible for managing the file generation. This class receives a implementation of the AbstractPaymentsFileFactory, that has methods signatures for files generation.

And I too created two concrete implementations of this class, one for the each bank, being XPTOBankPaymentsFileFactory and XYZBankPaymentsFileFactory.

## Scenario

In this scenario we have two banks, XYZ Bank, and XPTO Bank, each bank has your own layout definition. Look below the layouts structure.

Both layouts has the same structure, being:

```
HEADER           {1..1}
BATCH-HEADER     {1..N}
PAYMENT-DETAILS  {1..N}
BATCH-TRAILER    {1..N}
TRAILER          {1..1}
```

## Custom Layout

### Layout Structure for XPTO Bank                                           

*All lines of this layout are size 14*

*HEADER*
 
 * Position 1 -  5 Bank Code                                              
 
 * Position 6 - 14 Currente Date ('yyyyMMdd')                             
 
*BATCH-HEADER*

 * Position 1 -  5 Bank Code                                              
 
 * Position 6 - 14 Payment Type                                           
 
*DETAILS*

 * Position 1 -  5 Bank Code                                              
 
 * Position 6 - 14 Payment Value                                          
 
*BATCH-TRAILER*

 * Position 1 -  5 Bank Code                                              
 
 * Position 6 - 14 Amount of Payments                                     
 
*TRAILER*                                                             

 * Position 1 -  5 Bank Code                                              
 
 * Position 6 - 14 Number of lots                                         
  
### Layout Structure for XYZ Bank                                           

*All lines of this layout are size 19*                                   

*HEADER*
 
 * Position 1 -  5 Bank Code
 
 * Position 6 - 20 Currente Date and Time ('yyyyMMddHHmmss')
 
*BATCH-HEADER*

 * Position  1 -  5 Bank Code
 
 * Position  6 - 14 Payment Type
  
 * Position 15 - 20 Fills Blank
 
*DETAILS*

 * Position  1 -  5 Bank Code 
 
 * Position  6 - 14 Payment Value
 
 * Position 15 - 20 Entry Date ('yyMMdd')
 
*BATCH-TRAILER*

 * Position  1 -  5 Bank Code
 
 * Position  6 - 12 Amount of Payments
 
 * Position 13 - 20 Amount Value
 
*TRAILER*

 * Position  1 -  5 Bank Code
 
 * Position  6 - 14 Number of lots
  
 * Position 15 - 20 Fills Blank
