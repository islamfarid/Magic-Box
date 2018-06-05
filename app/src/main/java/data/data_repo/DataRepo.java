package data.data_repo;

import java.util.ArrayList;

import data.CellModel;

/**
 * Created by islam on 03/06/18.
 */

public class DataRepo {
    public ArrayList<ArrayList<CellModel>> getArrayOfData(int n) {
        ArrayList<ArrayList<CellModel>> cellsArrays = new ArrayList<>(n);
        int currentHorizontalCellIndex = Math.abs(n / 2);
        int currentVerticalIndex = n-1;
        int currentValue = 0;
        int tempcurrentHorizontalCellIndex, tempcurrentVerticalIndex;

        for (int i = 0; i < n; i++) {
            cellsArrays.add(new ArrayList<CellModel>(n));
            for(int k =0 ; k < n ; k++){
                cellsArrays.get(i).add(new CellModel());
            }
        }
        boolean  isRightAndDownHasValue = false, isUpHasValue = false;

        cellsArrays.get(currentVerticalIndex).get(currentHorizontalCellIndex ).setValue(++currentValue);
        cellsArrays.get(currentVerticalIndex).get(currentHorizontalCellIndex ).setHasValue(true);
        do{
            isRightAndDownHasValue = false;
            isUpHasValue = false;
            tempcurrentHorizontalCellIndex = currentHorizontalCellIndex +1;
            tempcurrentVerticalIndex = currentVerticalIndex + 1;
            if(tempcurrentHorizontalCellIndex >= n){
                tempcurrentHorizontalCellIndex = 0;
            }
            if(tempcurrentVerticalIndex >= n){
                tempcurrentVerticalIndex = 0;
            }
            if(!cellsArrays.get(tempcurrentVerticalIndex).get(tempcurrentHorizontalCellIndex).isHasValue()){
                cellsArrays.get(tempcurrentVerticalIndex).get(tempcurrentHorizontalCellIndex ).setValue(++currentValue);
                cellsArrays.get(tempcurrentVerticalIndex).get(tempcurrentHorizontalCellIndex ).setHasValue(true);
            }else {
                isRightAndDownHasValue = true;
            }
            if(isRightAndDownHasValue){
                tempcurrentHorizontalCellIndex = currentHorizontalCellIndex;
                tempcurrentVerticalIndex = currentVerticalIndex -1;
                if(tempcurrentVerticalIndex < 0){
                    tempcurrentVerticalIndex = n-1;
                }
                if(!cellsArrays.get(tempcurrentVerticalIndex).get(tempcurrentHorizontalCellIndex) .isHasValue()){
                    cellsArrays.get(tempcurrentVerticalIndex).get(tempcurrentHorizontalCellIndex ).setValue(++currentValue);
                    cellsArrays.get(tempcurrentVerticalIndex).get(tempcurrentHorizontalCellIndex ).setHasValue(true);
                }else {
                    isUpHasValue = true;
                }
            }
            currentHorizontalCellIndex = tempcurrentHorizontalCellIndex;
            currentVerticalIndex = tempcurrentVerticalIndex;
        }while (!(isRightAndDownHasValue && isUpHasValue));
            return cellsArrays;
    }
}
