package net.ontrack.web.gui;

import java.io.IOException;
import java.util.Locale;

import javax.servlet.http.HttpServletResponse;

import net.ontrack.core.model.UserMessage;
import net.ontrack.core.support.InputException;
import net.ontrack.core.ui.ManageUI;
import net.ontrack.web.support.AbstractGUIController;
import net.ontrack.web.support.ErrorHandler;
import net.sf.jstring.Strings;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class GUIController extends AbstractGUIController {

	private final Strings strings;
	private final ManageUI manageUI;

	@Autowired
	public GUIController(ErrorHandler errorHandler, Strings strings, ManageUI manageUI) {
		super(errorHandler);
		this.manageUI = manageUI;
		this.strings = strings;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		// OK
		return "home";
	}

	@RequestMapping(value = "/gui/project/{name:[A-Z0-9_\\.]+}", method = RequestMethod.GET)
	public String getProject(Model model, @PathVariable String name) {
		// Loads the project details
		model.addAttribute("project", manageUI.getProject(name));
		// OK
		return "project";
	}

	@RequestMapping(value = "/gui/branch/{project:[A-Z0-9_\\.]+}/{name:[A-Z0-9_\\.]+}", method = RequestMethod.GET)
	public String getBranch(Model model, @PathVariable String project, @PathVariable String name) {
		// Loads the details
		model.addAttribute("branch", manageUI.getBranch(project, name));
		// OK
		return "branch";
	}

	@RequestMapping(value = "/gui/build/{project:[A-Z0-9_\\.]+}/{branch:[A-Z0-9_\\.]+}/{name:[A-Z0-9_\\.]+}", method = RequestMethod.GET)
	public String getBranch(Model model, @PathVariable String project, @PathVariable String branch, @PathVariable String name) {
		// Loads the details
		model.addAttribute("build", manageUI.getBuild(project, branch, name));
		// OK
		return "build";
	}

	@RequestMapping(value = "/gui/validation_stamp/{project:[A-Z0-9_\\.]+}/{branch:[A-Z0-9_\\.]+}/{name:[A-Z0-9_\\.]+}", method = RequestMethod.GET)
	public String getValidationStamp(Model model, @PathVariable String project, @PathVariable String branch, @PathVariable String name) {
		// Loads the details
		model.addAttribute("validationStamp", manageUI.getValidationStamp(project, branch, name));
		// OK
		return "validationStamp";
	}

	@RequestMapping(value = "/gui/validation_stamp/{project:[A-Z0-9_\\.]+}/{branch:[A-Z0-9_\\.]+}/{name:[A-Z0-9_\\.]+}/image", method = RequestMethod.POST)
	public String imageValidationStamp(Locale locale, Model model, @PathVariable String project, @PathVariable String branch, @PathVariable String name, @RequestParam MultipartFile image) {
		try {
			// TODO Custom (global) error handler for the upload exceptions
			// Upload
			manageUI.setImageValidationStamp(project, branch, name, image);
			// Success
			model.addAttribute("imageMessage", UserMessage.success(strings.get(locale, "validation_stamp.image.success")));
		} catch (InputException ex) {
			// Error
			model.addAttribute("imageMessage", UserMessage.error(errorHandler.displayableError(ex, locale)));
		}
		// OK
		return getValidationStamp(model, project, branch, name);
	}
	
	@RequestMapping(value = "/gui/validation_stamp/{project:[A-Z0-9_\\.]+}/{branch:[A-Z0-9_\\.]+}/{name:[A-Z0-9_\\.]+}/image", method = RequestMethod.GET)
	public void getImageValidationStamp(@PathVariable String project, @PathVariable String branch, @PathVariable String name, HttpServletResponse response) throws IOException {
		byte[] content = manageUI.imageValidationStamp(project, branch, name);
		if (content == null) {
			content = Base64.decodeBase64("iVBORw0KGgoAAAANSUhEUgAAAAEAAAABCAIAAACQd1PeAAAAE0lEQVR4XgXAAQ0AAABAMP1L38IF/gL+/AQ1bQAAAABJRU5ErkJggg==");
		}
		response.setContentType("image/png");
		response.setContentLength(content.length);
		response.setStatus(HttpServletResponse.SC_OK);
		response.getOutputStream().write(content);
		response.getOutputStream().flush();
	}

}