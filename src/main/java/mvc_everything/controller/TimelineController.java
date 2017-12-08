package mvc_everything.controller;

import java.util.list;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import mvc_everything.model.Timeline;
import mvc_everything.service.TimelineService;

@Controller
public class TimelineController 
{
	@Autowired
	TimelineService timelineService;
	@RequestMapping(value="/timeline",method=RequestMethod.GET)
	String ShowTimeline(@RequestParam(required=false) Long id, ModelMap model)
	{
		Lista<Timeline> timelines=timelineService.findAll();
		model.addAttribute("timelines",timelines);
		return "timelines";
	}
}
