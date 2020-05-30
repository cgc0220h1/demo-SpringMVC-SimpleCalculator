package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
@RequestMapping("/")
public class CalculatorController {
    private Pattern pattern;
    private Matcher matcher;
    public static final String OPERAND_REGEX = "\\d*";

    @GetMapping
    public ModelAndView showIndex() {
        return new ModelAndView("index");
    }

    @PostMapping
    public ModelAndView showResult(@RequestParam("operand") String[] operands, @RequestParam("operator") String operator) {
        ModelAndView modelAndView = new ModelAndView("index");
        String result;
        pattern = Pattern.compile(OPERAND_REGEX);

        if (operands.length > 2) {
            result = "Invalid Input!. Please enter 2 operands!";
            modelAndView.addObject("result", result);
            return modelAndView;
        }

        for (String operand : operands) {
            matcher = pattern.matcher(operand);
            if (!matcher.matches()) {
                result = "Invalid Input!. Please enter a Integer Number";
                modelAndView.addObject("result", result);
                return modelAndView;
            }
        }

        switch (operator) {
            case "add":
                result = String.valueOf(Integer.parseInt(operands[0]) + Integer.parseInt(operands[1]));
                break;
            case "subtract":
                result = String.valueOf(Integer.parseInt(operands[0]) - Integer.parseInt(operands[1]));
                break;
            case "multiply":
                result = String.valueOf(Integer.parseInt(operands[0]) * Integer.parseInt(operands[1]));
                break;
            case "divide":
                try {
                    result = String.valueOf(Integer.parseInt(operands[0]) / Integer.parseInt(operands[1]));
                } catch (ArithmeticException ex) {
                    result = "Invalid Input!. Cant divide by Zero";
                }
                break;
            default:
                result = "No Value!";
        }
        modelAndView.addObject("result", result);
        return modelAndView;
    }
}