package org.bentonc.codingquestions.geeksforgeeks;

import java.util.ArrayList;
import java.util.List;

/**
 * https://www.geeksforgeeks.org/print-all-possible-expressions-that-evaluate-to-a-target/
 *
 * Print all possible expressions that evaluate to a target.
 *
 * Given a string that contains only digits from 0 to 9, and an integer value, target. Find out how many expressions
 * are possible which evaluate to target using binary operator +, – and * in given string of digits.
 */
public class GetExpressions {
    public static void recursive(
            final int target,
            final String input,
            final int position,
            final String currentExpression,
            final int currentTotal,
            final int lastValue,
            List<String> result
    ) {
        // System.out.println(
        //         "position:" + position +
        //         ",currentExpression:" + currentExpression +
        //         ",currentTotal:" + currentTotal +
        //         ",lastValue:" + lastValue
        // );

        if (position >= input.length()) {
            if (currentTotal == target) {
                result.add(currentExpression);
            }

            return;
        }

        for (int i = position; i < input.length(); ++i) {
            // System.out.println("input:" + input);
            // System.out.println("position:" + position);
            String part = input.substring(position, i + 1);

            // System.out.println("part:" + part);
            int currentValue = Integer.parseInt(part);

            if (position == 0) {
                recursive(
                        target,
                        input,
                        i + 1,
                        currentExpression + part,
                        currentValue,
                        currentValue,
                        result
                );
            }

            else {
                recursive(
                        target,
                        input,
                        i + 1,
                        currentExpression + "+" + part,
                        currentTotal + currentValue,
                        currentValue,
                        result
                );

                recursive(
                        target,
                        input,
                        i + 1,
                        currentExpression + "-" + part,
                        currentTotal - currentValue,
                        -currentValue,
                        result
                );

                recursive(
                        target,
                        input,
                        i + 1,
                        currentExpression + "*" + part,
                        (currentTotal - lastValue) + (lastValue * currentValue),
                        lastValue * currentValue,
                        result
                );
            }
        }
    }
}
