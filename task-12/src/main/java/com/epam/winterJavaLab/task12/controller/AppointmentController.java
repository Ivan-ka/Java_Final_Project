package com.epam.winterJavaLab.task12.controller;

import com.epam.winterJavaLab.task12.constants.ConstantsView;
import com.epam.winterJavaLab.task12.entity.Appointment;
import com.epam.winterJavaLab.task12.entity.User;
import com.epam.winterJavaLab.task12.exception.CustomException;
import com.epam.winterJavaLab.task12.service.interfaces.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.Date;
import java.util.List;


@Controller
@RequestMapping(ConstantsView.SLASH)
public class AppointmentController {

    private static Date date = new Date(System.currentTimeMillis());

    private AppointmentService appointmentService;
    private BasketService basketService;
    private DoctorService doctorService;
    private DiagnosisService diagnosisService;
    private UserService userService;


    @Autowired
    public AppointmentController(AppointmentService appointmentService, BasketService basketService,
                                 DoctorService doctorService, DiagnosisService diagnosisService, UserService userService) {
        this.appointmentService = appointmentService;
        this.basketService = basketService;
        this.doctorService = doctorService;
        this.diagnosisService = diagnosisService;
        this.userService = userService;
    }



    @GetMapping(ConstantsView.APPOINTMENTS_PATH)
    public String getAllAppointments(Model model) {
        List<Appointment> listAppointments = appointmentService.getAllAppointments();
        model.addAttribute("listAppointments", listAppointments);
        return ConstantsView.APPOINTMENTS_TEMPLATE;
    }


    @GetMapping(ConstantsView.PROFILE_PATH)
    public String getProfile(Model model) {
        User user = userService.getUser(SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString());
        List<Appointment> listAppointments = appointmentService.getAppointmentsByPatientId();
        model.addAttribute("listAppointments", listAppointments);
        model.addAttribute("user", user);
        return ConstantsView.PROFILE_TEMPLATE;
    }


    @GetMapping(ConstantsView.BASKET_PATH)
    public String getBasket(Model model) {
        List<Appointment> listAppointments = basketService.getBasketAppointmentsByPatientId();
        model.addAttribute("listAppointments", listAppointments);
        return ConstantsView.BASKET_TEMPLATE;
    }


    @GetMapping(ConstantsView.CREATE_APPOINTMENT_PATH)
    public String createAppointment(Model model) {
        model.addAttribute("appointment", new Appointment());
        model.addAttribute("doctorsList", doctorService.getAllDoctors());
        model.addAttribute("diagnosesList", diagnosisService.getAllDiagnoses());
        model.addAttribute("currentDate", date);
        return ConstantsView.CREATE_APPOINTMENT_TEMPLATE;
    }


    @PostMapping(ConstantsView.CREATE_APPOINTMENT_PATH)
    public String createAppointmentForm(@ModelAttribute @Valid Appointment appointment,  BindingResult result, Model model) {

        if (result.hasErrors()) {
            model.addAttribute("diagnosesList", diagnosisService.getAllDiagnoses());
            model.addAttribute("doctorsList", doctorService.getAllDoctors());
            model.addAttribute("currentDate", date);
            return ConstantsView.CREATE_APPOINTMENT_TEMPLATE;
        }

        if (basketService.findDoctorMatch(appointment.getDat(), appointment.getDoctor()) == 5) {
            throw new CustomException("888", "On the indicated date: " + appointment.getDat() +
                    ", you cannot make an appointment with the doctor: " + appointment.getDoctor());
        }

        if (basketService.findDateMatch(appointment.getDat()) == 3) {
            throw new CustomException("999", "You have exceeded the number of appointments on a given date: " + appointment.getDat());
        }

        basketService.addBasketAppointment(appointment);
        return ConstantsView.BASKET_PATH_WITH_REDIRECT;
    }


    @GetMapping(ConstantsView.EDIT_PATH)
    public String editAppointment(@PathVariable("id") Long id, Model model) {
        model.addAttribute("appointment", appointmentService.getAppointment(id));
        model.addAttribute("doctorsList", doctorService.getAllDoctors());
        model.addAttribute("diagnosesList", diagnosisService.getAllDiagnoses());
        model.addAttribute("currentDate", date);
        return ConstantsView.EDIT_APPOINTMENT_TEMPLATE;
    }


    @PostMapping(ConstantsView.EDIT_APPOINTMENT_PATH)
    public String editAppointmentForm(@ModelAttribute Appointment appointment) {
        appointmentService.updateAppointment(appointment);
        return ConstantsView.APPOINTMENTS_PATH_WITH_REDIRECT;
    }


    @GetMapping(ConstantsView.DELETE_PATH)
    public String deleteAppointment(@PathVariable("id") Long id) {
        appointmentService.deleteAppointment(id);
        return ConstantsView.APPOINTMENTS_PATH_WITH_REDIRECT;
    }


    @GetMapping(ConstantsView.BASKET_EDIT_PATH)
    public String editBasketAppointment(@PathVariable("id") Long id, Model model) {
        model.addAttribute("appointment", basketService.getBasketAppointment(id));
        model.addAttribute("doctorsList", doctorService.getAllDoctors());
        model.addAttribute("diagnosesList", diagnosisService.getAllDiagnoses());
        model.addAttribute("currentDate", date);
        return ConstantsView.EDIT_BASKET_APPOINTMENT_TEMPLATE;
    }


    @PostMapping(ConstantsView.EDIT_BASKET_APPOINTMENT_PATH)
    public String editBasketAppointmentForm(@ModelAttribute Appointment appointment) {

        if (basketService.findDateMatch(appointment.getDat()) == 3) {
            throw new CustomException("999", "You have exceeded the number of appointments on a given date: " + appointment.getDat());
        }

        if (basketService.findDoctorMatch(appointment.getDat(), appointment.getDoctor()) == 5) {
            throw new CustomException("888", "On the indicated date: " + appointment.getDat() +
                    ", you cannot make an appointment with the doctor: " + appointment.getDoctor());
        }

        basketService.updateBasketAppointment(appointment);
        return ConstantsView.BASKET_PATH_WITH_REDIRECT;
    }


    @GetMapping(ConstantsView.BASKET_DELETE_PATH)
    public String deleteBasketAppointment(@PathVariable("id") Long id) {
        basketService.deleteBasketAppointment(id);
        return ConstantsView.BASKET_PATH_WITH_REDIRECT;
    }


    @GetMapping(ConstantsView.APPROVE_PATH)
    public String deleteBasketAppointment() {
        appointmentService.addFromBasket();
        return ConstantsView.PROFILE_PATH_WITH_REDIRECT;
    }

}
