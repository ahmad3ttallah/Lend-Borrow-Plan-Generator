package net.hopesun.BorrowerPlan.utils;

import java.io.IOException;
import java.text.DecimalFormat;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class SerializeDouble2Decimal extends JsonSerializer<Double> {
    @Override
    public void serialize(Double value, JsonGenerator jgen, SerializerProvider provider) throws IOException, JsonGenerationException {
        if (null == value) {
        	jgen.writeNumber(0);
        } else {
            jgen.writeNumber(round2Decimals(value));
        }
    }
    
    public static String round2Decimals(Double value) {
    	final String pattern = "#.##";
        final DecimalFormat myFormatter = new DecimalFormat(pattern);
        final String output = myFormatter.format(value);
        return output;
    }
}