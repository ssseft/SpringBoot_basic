package com.mysite.bbs.contact;

import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ContactController {
	private final ContactService contactService;
	
	//시작화면
	@RequestMapping("/")
	public String root() {
		return "index";
	}
	
	//등록폼
	@GetMapping("/enrollment")
    public String enrollment() {
        return "enrollment";
    }
	
	//등록화면
	@GetMapping("/new")
    public String insert(@RequestParam("id") String id,
                         @RequestParam("name") String name,
                         @RequestParam("number") String number,
                         @RequestParam("email") String email,
                         @RequestParam("address") String address) {
        Contact contact = new Contact();
        contact.setId(id);
        contact.setName(name);
        contact.setNumber(number);
        contact.setEmail(email);
        contact.setAddress(address);
        contact.setCreatedate(LocalDateTime.now());

        contactService.save(contact);

        return "redirect:/list";
    }
	
	@GetMapping("/list")
    public String listContacts(Model model) {
        model.addAttribute("contacts", contactService.getList());
        return "list";
    }
	
	@GetMapping("/list/detail/{no}")
    public String viewContact(@PathVariable("no") int no, Model model) {
        Contact contact = contactService.getContact(no);
        model.addAttribute("contact", contact);
        return "list_detail";
    }
	
	@GetMapping("/edit/{no}")
    public String reviseForm(@PathVariable("no") int no, Model model) {
        Contact contact = contactService.getContact(no);
        model.addAttribute("contact", contact);
        return "revise";
    }
	
	@GetMapping("/delete/{no}")
	public String deleteContact(@PathVariable("no") int no) {
	    contactService.deleteContact(no);
	    return "redirect:/list";
	}
	
	
	@GetMapping("/edit/submit")
    public String updateContact(@RequestParam("no") int no,
                                @RequestParam("id") String id,
                                @RequestParam("name") String name,
                                @RequestParam("number") String number,
                                @RequestParam("email") String email,
                                @RequestParam("address") String address) {
        Contact contact = contactService.getContact(no);
        contact.setId(id); // 수정된 ID 설정
        contact.setName(name);
        contact.setNumber(number);
        contact.setEmail(email);
        contact.setAddress(address);
        contactService.updateContact(contact);

        return "redirect:/list";
    }
	
}
