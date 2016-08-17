package desktopadmin.facebook;


import facebook4j.Comment;
import facebook4j.Facebook;
import facebook4j.FacebookException;
import facebook4j.FacebookFactory;
import facebook4j.Group;
import facebook4j.Page;
import facebook4j.Post;
import facebook4j.ResponseList;
import facebook4j.auth.AccessToken;
import facebook4j.internal.org.json.JSONException;


public class MyFacebook
{
	//name='Tripoli MaZad', id='376852895794717' post_id = 376852895794717_925263387620329
	//name='Tripoli MaZad', id='248557325166196' 
	//name='Tripoli MaZad', id='184089698405788' post_id = 184089698405788_666681503479936
	
	public static void main(String[] args) throws JSONException
	{
		Facebook facebook = new FacebookFactory().getInstance();
		facebook.setOAuthAppId("621142834726679", "b18a584c778f0fedcbce02f5a62d7a87");
		facebook.setOAuthPermissions("public_profile,user_friends,email,user_about_me,user_actions.books,user_actions.fitness,user_actions.music,user_actions.news,user_actions.video,user_birthday,user_education_history,user_events,user_games_activity,user_hometown,user_likes,user_location,user_managed_groups,user_photos,user_posts,user_relationships,user_relationship_details,user_religion_politics,user_tagged_places,user_videos,user_website,user_work_history,read_custom_friendlists,read_insights,read_audience_network_insights,read_page_mailboxes,manage_pages,publish_pages,publish_actions,rsvp_event,pages_show_list,pages_manage_cta,pages_manage_instant_articles,ads_read,ads_management,business_management,pages_messaging,pages_messaging_phone_number");
		//facebook.setOAuthAccessToken(new AccessToken("EAACEdEose0cBAIcdDSgvfZAIWdtTqZCGiIeBdoHZBsz4utGiFLpySQMGIZAZC1enxCEugiozkoZBAbDOZA8ouTOSTyZBbwKbrQ9HWXr4rMK9Oklpgcg5yAmXtk55kxgxEUcDz9MCh6bElzm4q0VqlPKHYtdhJbHKRAGaGmZCPN3YmUgTDNd5mPNk7HBn0uFGhZAPvPNiQAAfl84wZDZD", null));
		facebook.setOAuthAccessToken(new AccessToken("621142834726679|b18a584c778f0fedcbce02f5a62d7a87", null));
		try
		{
			Group group = facebook.getGroup("376852895794717");
			Page page = facebook.getPage("669427929844831");
			 ResponseList<Post> feed = facebook.getFeed("669427929844831");
		//	 System.out.println(feed);
			/* for(Post post:feed)
			 {
				 System.out.println(post.getComments());
			 }*/
			 Post post = facebook.getPost("669427929844831_990714357716185");
			// Post post_tripoli_mazad = facebook.getPost("184089698405788_666681503479936");
			// Post post_tripoli_mazad2 = facebook.getPost("184089698405788_666681503479936");
			// System.out.println(post);
			 //System.out.println(post_tripoli_mazad);
			 
			 
			/* for(Post post2:facebook.getGroupFeed("376852895794717"))
			 {
				 System.out.println(post2.getFrom());
				 System.out.println(post2.getId());
			 }*/
			 
			 for(Comment comment:post.getComments())
			 {
				 System.out.println(comment.getMessage());
				 if(comment.getMessage().equals("."))
					// if( comment.canRemove())
					 facebook.deleteComment(comment.getId());
						
			 }
			 
			// facebook.commentPost("184089698405788_666681503479936", ".");
			/*for(Group group2:facebook.getGroups())
				{
				System.out.println(group2);
				};*/
			 
			 //System.out.println(group.getName());
			 
			// System.out.println(post.getComments());
			/* PagableList<Comment> comments = post.getComments();
			 for(Comment comment:comments)
				 System.out.println(comment);*/
	           
		}
		catch (FacebookException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
