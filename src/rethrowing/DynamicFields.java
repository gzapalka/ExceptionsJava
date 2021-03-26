package rethrowing;

public class DynamicFields {
    private Object[][] fields;

    public DynamicFields(int initialSize){
        fields = new Object[initialSize][2];
        for(int i =0; i<initialSize; i++){
            fields[i]= new Object[]{null, null};
        }
    }

    @Override
    public String toString(){
        StringBuilder result = new StringBuilder();
        for(Object[] obj : fields){
            result.append(obj[0]);
            result.append(": ");
            result.append(obj[1]);
            result.append("\n");
        }
        return result.toString();
    }

    private int hasField(String id){
        for(int i=0; i<fields.length; i++){
            if(id.equals(fields[i][0]))
                return i;
        }
        return -1;
    }

    private int getFieldNumber(String id) throws NoSuchFieldException{
        int fieldNum = hasField(id);
        if(fieldNum == -1){
            throw new NoSuchFieldException();
        }
        return fieldNum;
    }

    private int makeField(String id){
        for(int i =0; i<fields.length; i++){
            if(fields[i][0] == null){
                fields[i][0] = id;
                return i;
            }
        }

        Object[][] temp = new Object[fields.length+1][2];
        System.arraycopy(fields, 0, temp, 0, fields.length);
        for(int i =fields.length; i< temp.length; i++){
            temp[i] = new Object[]{null, null};
        }
        fields = temp;

        return makeField(id);
    }


    public Object getFields(String id) throws NoSuchFieldException {
        return fields[getFieldNumber(id)][1];
    }

    public Object setField(String id, Object value) throws DynamicFieldException, NoSuchFieldException{
        if(value == null){
            DynamicFieldException dynamicFieldException = new DynamicFieldException();
            dynamicFieldException.initCause(new NullPointerException());
            throw dynamicFieldException;
        }

        int fieldNumber = hasField(id);
        if(fieldNumber == -1){
            fieldNumber= makeField(id);
        }

        Object result;
        try{
            result = getFields(id);
        } catch(NoSuchFieldException e){
            throw new RuntimeException(e);
        }

        fields[fieldNumber][1] = value;
        return result;
    }

    public static void main(String[] args) {
        DynamicFields dynamicFields = new DynamicFields(3);
        System.out.println(dynamicFields);
        try{
            dynamicFields.setField("d", "d value");
            dynamicFields.setField("e", "e value");
            dynamicFields.setField("i", "i value");
            System.out.println(dynamicFields);

            dynamicFields.setField("d", "new d value");
            dynamicFields.setField("3", "value of 3");
            System.out.println(dynamicFields);
            Object field = dynamicFields.setField("d", null);
            System.out.println(dynamicFields);

        }catch (NoSuchFieldException | DynamicFieldException e){
            e.printStackTrace();
        }
    }
}
