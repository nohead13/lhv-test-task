Manual test cases: leasing calculator
================================
#### Test 1: Check asset minimal value (>7500)

💡 **Tip:** *Could be automated*
1. Open LHV page
2. Move leasing calculator
3. Input into "Price of the vehicle" value=7499 €
4. **Expected result**: Should be shown message about "Asset purchase price
   From 7500 €"
5. **Actual result**: No warning message, possible move to  application by button "Apply here"

#### Test 2: Check  financial amount minimal value (>5000)

💡 **Tip:** *Could be automated*
1. Open LHV page
2. Move leasing calculator
3. Input into "Price of the vehicle" value=7500 €
4. Input into "Downpayment" value=1500 €
5. Input into "Residual value" value=1001 €
6. **Expected result**: Should be shown message about "Minimum financed amount 5000 €"
7. **Actual result**: No warning message, possible move to  application by button "Apply here"

#### Test 3: Check leasing period for private person with financial lease

💡 **Tip:** *Should be automated*
1. Open LHV page
2. Move leasing calculator
3. Check "as a private person" selected
4. Check "financial lease" selected
5. Check period could be selected:
   1. 0 years, 6 month => **Expected**: Calculation happened
   2. 0 years, 1-5 month => **Expected**: No calculation. **Actual**: from 2 month calculation work
   3. select 5 month, then 7 years => **Expected**: Calculation happened, shown only year block
   4. select 12 month => **Expected**: year automatically changed +1

#### Test 4: Check leasing period for private person with operational lease

💡 **Tip:** *Should be automated*
1. Open LHV page
2. Move leasing calculator
3. Select "as a private person"
4. Select "operational lease"
5. Check period could be selected:
    1. 0 years, 6 month => **Expected**: Calculation happened
    2. 0 years, 1-5 month => **Expected**: No calculation. **Actual**: from 2 month calculation work)
    3. 6 years => **Expected**: Calculation happened, shown only year block

#### Test 5: Check leasing period for legal person with financial lease flow

*Could be automated*

1. Open LHV page
2. Move leasing calculator
3. Select "as a legal person"
4. Check "financial lease" selected
5. Check "The price includes VAT" selected
6. Shown dropdown for "Payment of VAT" with options:
   * "Including the down-payment"
   * "Timing over three months"
   * "Payment in the third month"
7. Uncheck "The price includes VAT"
8. Dropdown not shown "Payment of VAT"

#### Test 6: Check leasing period for legal person with operational lease flow

*Could be automated*

1. Open LHV page
2. Move leasing calculator
3. Select "as a legal person"
4. Check "financial lease" selected
5. Check "The price includes VAT" selected
6. Dropdown not shown "Payment of VAT"

#### Test 7: Check calculator with negative input 

💡 **Tip:** *Could be automated*
1. Open LHV page
2. Move leasing calculator
3. Check negative input:
   * Into "Price of the vehicle" => Monthly instalment should be zero
   * Into "Downpayment" (value, percentage) => **Expected**: ignore minus mark. **Actual**: calculated as negative value.
   * Into "Interest" => **Expected** : ignore minus mark. **Actual**: calculated as negative value.
   * Into "Residual value" (value, percentage) => **Expected** : ignore minus mark. **Actual**: calculated as negative value.

#### Test 8: Check calculator with wrong input text into "Price of the vehicle"

💡 **Tip:** *Could be automated*
1. Open LHV page
2. Move leasing calculator
3. Default values prefilled for "Price of the vehicle", "Downpayment", "Interest", "Residual value"
4. Put text input: (example: abc!) Into "Price of the vehicle"
5. **Expected** :=> Monthly instalment should be zero

#### Test 9: Check calculator with wrong input text into "Downpayment" and "Residual value"

💡 **Tip:** *Could be automated*
1. Open LHV page
2. Move leasing calculator
3. Default values prefilled for "Price of the vehicle", "Downpayment", "Interest", "Residual value"
4. Put text input: (example: abc!) 
   * Into "Downpayment" percentage => **Expected** : Calculation not changed, currency value changed to zero.
   * Into "Downpayment" currency value => **Expected** : Calculation not changed, percentage value equal to zero.
   * Into "Residual value" percentage => **Expected** : Calculation not changed, currency value changed to zero.
   * Into "Residual value" currency value => **Expected** : Calculation not changed, percentage value equal to zero.


#### Test 10: Check calculator with wrong input text into "Interest"

💡 **Tip:** *Could be automated*
1. Open LHV page
2. Move leasing calculator
3. Default values prefilled for "Price of the vehicle", "Downpayment", "Interest", "Residual value"
4. Put text input: (example: abc!)
    * Into "Interest" percentage => **Expected** : Monthly instalment should be zero.
