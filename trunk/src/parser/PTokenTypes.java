// $ANTLR 2.7.7 (2006-11-01): "src/parser/parser.g" -> "P.java"$

package parser;

public interface PTokenTypes {
	int EOF = 1;
	int NULL_TREE_LOOKAHEAD = 3;
	int SELECT_STATEMENT = 4;
	int SUBQUERY = 5;
	int GROUP_BY = 6;
	int ORDER_BY = 7;
	int ALIAS_EQU = 8;
	int FUNCTION = 9;
	int LOGIC_OP = 10;
	int CONTAIN_OP = 11;
	int SUBCONTAIN_OP = 12;
	int ALL_FIELDS = 13;
	int LOGIC_BLOCK = 14;
	int COLUMN = 15;
	int WHERE = 16;
	int SEMI = 17;
	int LITERAL_t_union = 18;
	// "\u8868\u5408\u5e76" = 19
	int COMMA = 20;
	int LITERAL_t_compare = 21;
	// "\u8868\u6bd4\u8f83" = 22
	int LITERAL_where = 23;
	// "\u6761\u4ef6" = 24
	int LITERAL_select = 25;
	// "\u67e5\u8be2" = 26
	int LITERAL_distinct = 27;
	// "\u552f\u4e00" = 28
	int LITERAL_from = 29;
	// "\u6765\u81ea" = 30
	int LITERAL_group = 31;
	int LITERAL_by = 32;
	// "\u5206\u7ec4" = 33
	int LITERAL_order = 34;
	// "\u6392\u5e8f" = 35
	int LITERAL_not = 36;
	// "\u975e" = 37
	int LITERAL_and = 38;
	int LITERAL_or = 39;
	// "\u5e76\u4e14" = 40
	// "\u6216\u8005" = 41
	int LPAREN = 42;
	int RPAREN = 43;
	int LITERAL_as = 44;
	// "\u4f5c\u4e3a" = 45
	// "=" = 46
	// "\u7b49\u4e8e" = 47
	// "\u6240\u6709" = 48
	int STAR = 49;
	// "\u5347\u5e8f" = 50
	// "\u964d\u5e8f" = 51
	int LITERAL_asc = 52;
	int LITERAL_desc = 53;
	int LITERAL_is = 54;
	int LITERAL_null = 55;
	// "\u4e3a\u7a7a" = 56
	// "\u975e\u7a7a" = 57
	int LITERAL_between = 58;
	// "\u8303\u56f4" = 59
	// "not in" = 60
	int LITERAL_in = 61;
	// "\u5728\u4e8e" = 62
	// "\u4e0d\u5728\u4e8e" = 63
	int PARAM_ID = 64;
	int ID = 65;
	int QUOTED_STRING = 66;
	int POINT = 67;
	int REAL_NUM = 68;
	int NEGATIVE_DIGIT_ELEMENT = 69;
	int LITERAL_all = 70;
	// "\u5168\u90e8" = 71
	int LITERAL_sum = 72;
	// "\u6c42\u548c" = 73
	int LITERAL_avg = 74;
	// "\u6c42\u5e73\u5747\u6570" = 75
	int LITERAL_max = 76;
	// "\u6c42\u6700\u5927\u503c" = 77
	int LITERAL_min = 78;
	// "\u6c42\u6700\u5c0f\u503c" = 79
	int LITERAL_count = 80;
	// "\u6c42\u8bb0\u5f55\u6570" = 81
	int LITERAL_abs = 82;
	// "\u53d6\u7edd\u5bf9\u503c" = 83
	int LITERAL_acos = 84;
	// "\u6c42\u503c\u7684\u4f59\u5f26\u89d2" = 85
	int LITERAL_asin = 86;
	// "\u6c42\u503c\u7684\u6b63\u5f26\u89d2" = 87
	int LITERAL_atan = 88;
	// "\u6c42\u503c\u7684\u6b63\u5207\u89d2" = 89
	// "atin2" = 90
	// "\u6c42\u503c\u7684\u6b63\u5f26\u548c\u4f59\u5f26\u89d2" = 91
	int LITERAL_ceiling = 92;
	// "\u6c42\u4e94\u5165\u540e\u7684\u6574\u6570" = 93
	int LITERAL_cos = 94;
	// "\u6c42\u89d2\u7684\u4f59\u5f26\u503c" = 95
	int LITERAL_cot = 96;
	// "\u6c42\u89d2\u7684\u4f59\u5207\u503c" = 97
	int LITERAL_degrees = 98;
	// "\u6c42\u5f27\u5ea6\u6570\u7684\u89d2\u5927\u5c0f" = 99
	int LITERAL_exp = 100;
	// "\u6c42\u5e42\u503c" = 101
	int LITERAL_floor = 102;
	// "\u6c42\u56db\u820d\u540e\u7684\u6574\u6570" = 103
	int LITERAL_log = 104;
	// "\u6c42\u81ea\u7136\u5bf9\u6570" = 105
	// "log10" = 106
	// "\u6c4210\u4e3a\u5e95\u7684\u5bf9\u6570" = 107
	int LITERAL_mod = 108;
	// "\u6c42\u6a21" = 109
	int LITERAL_pi = 110;
	// "\u6c42PI" = 111
	int LITERAL_power = 112;
	// "\u6c42\u6570\u5b57\u7684\u6b21\u5e42\u503c" = 113
	int LITERAL_radians = 114;
	// "\u6c42\u5ea6\u6570\u89d2\u7684\u5f27\u5ea6" = 115
	int LITERAL_rand = 116;
	// "\u6c420\u548c1\u95f4\u7684\u968f\u673a\u6570" = 117
	int LITERAL_round = 118;
	// "\u683c\u5f0f\u5316\u6570\u503c" = 119
	int LITERAL_sign = 120;
	// "\u6c42\u503c\u7684\u7b26\u53f7" = 121
	int LITERAL_sin = 122;
	// "\u6c42\u89d2\u7684\u6b63\u5f26\u503c" = 123
	int LITERAL_sqrt = 124;
	// "\u6c42\u5e73\u65b9\u6839" = 125
	int LITERAL_tan = 126;
	// "\u6c42\u89d2\u7684\u6b63\u5207\u503c" = 127
	int LITERAL_ascii = 128;
	// "\u6c42\u7b2c\u4e00\u4e2a\u5b57\u7b26\u7684ASCII\u7801" = 129
	int LITERAL_char = 130;
	// "\u6c42\u7b49\u503c\u7684\u5b57\u7b26" = 131
	int LITERAL_char_length = 132;
	// "\u6c42\u5b57\u7b26\u4e32\u7684\u957f\u5ea6" = 133
	int LITERAL_charindex = 134;
	// "\u5b58\u5728\u4e8e" = 135
	int LITERAL_difference = 136;
	// "\u6c42\u4e24\u4e2a\u4e32\u7684\u5dee\u503c" = 137
	int LITERAL_lcase = 138;
	int LITERAL_left = 139;
	// "\u5b57\u7b26\u4e32\u5de6\u622a" = 140
	int LITERAL_length = 141;
	// "\u6c42\u5b57\u7b26\u4e32\u603b\u957f\u5ea6" = 142
	int LITERAL_lower = 143;
	// "\u5c06\u5b57\u7b26\u4e32\u8f6c\u4e3a\u5c0f\u5199" = 144
	int LITERAL_ltrim = 145;
	// "\u53bb\u6389\u5de6\u7a7a\u683c" = 146
	int LITERAL_patindex = 147;
	// "\u6c42\u7b2c\u4e00\u6b21\u51fa\u73b0\u4f4d\u7f6e" = 148
	int LITERAL_replace = 149;
	// "\u5b57\u7b26\u4e32\u66ff\u6362" = 150
	int LITERAL_right = 151;
	int LITERAL_rtrim = 152;
	// "\u53bb\u6389\u53f3\u7a7a\u683c" = 153
	int LITERAL_str = 154;
	// "\u6570\u503c\u8f6c\u5b57\u7b26\u4e32" = 155
	int LITERAL_substring = 156;
	// "\u5b57\u7b26\u4e32\u622a\u53d6" = 157
	int LITERAL_upper = 158;
	// "\u5c06\u5b57\u7b26\u4e32\u8f6c\u4e3a\u5927\u5199" = 159
	int LITERAL_dateformat = 160;
	// "\u683c\u5f0f\u5316\u65e5\u671f" = 161
	int LITERAL_datename = 162;
	// "\u6c42\u65e5\u671f\u7684\u5206\u91cf\u503c" = 163
	int LITERAL_datepart = 164;
	// "\u6c42\u65e5\u671f\u7684\u5206\u91cf\u6574\u6570\u503c" = 165
	int LITERAL_datetime = 166;
	// "\u8f6c\u4e3a\u65e5\u671f\u65f6\u95f4" = 167
	int LITERAL_date = 168;
	int LITERAL_dayname = 169;
	int LITERAL_days = 170;
	int LITERAL_day = 171;
	int LITERAL_dow = 172;
	int LITERAL_hours = 173;
	int LITERAL_hour = 174;
	int LITERAL_minutes = 175;
	int LITERAL_minute = 176;
	int LITERAL_monthname = 177;
	int LITERAL_months = 178;
	int LITERAL_month = 179;
	int LITERAL_now = 180;
	// "\u53d6\u5f53\u524d\u65e5\u671f\u65f6\u95f4" = 181
	int LITERAL_quarter = 182;
	int LITERAL_seconds = 183;
	int LITERAL_second = 184;
	int LITERAL_today = 185;
	// "\u53d6\u5f53\u524d\u65e5\u671f" = 186
	int LITERAL_weeks = 187;
	int LITERAL_week = 188;
	int LITERAL_years = 189;
	int LITERAL_year = 190;
	int LITERAL_getdate = 191;
	// "\u6c42\u5f53\u524d\u65e5\u671f\u65f6\u95f4" = 192
	int LITERAL_dateadd = 193;
	// "\u65e5\u671f\u76f8\u52a0" = 194
	int LITERAL_datediff = 195;
	// "\u65e5\u671f\u76f8\u51cf" = 196
	int LITERAL_convert = 197;
	// "\u5b57\u7b26\u8f6c\u4e3a\u65e5\u671f" = 198
	int LITERAL_hextoint = 199;
	// "\u5341\u516d\u8fdb\u5236\u8f6c\u4e3a\u6574\u6570" = 200
	int LITERAL_inttohex = 201;
	// "\u6574\u6570\u8f6c\u4e3a\u5341\u516d\u8fdb\u5236" = 202
	int LITERAL_isdate = 203;
	// "\u662f\u65e5\u671f\u578b" = 204
	int LITERAL_isnumeric = 205;
	// "\u662f\u6570\u503c\u578b" = 206
	int LITERAL_suser_id = 207;
	int LITERAL_suser_name = 208;
	int LITERAL_user_id = 209;
	int LITERAL_user_name = 210;
	int LITERAL_decode = 211;
	int LITERAL_dump = 212;
	int LITERAL_greatest = 213;
	int LITERAL_least = 214;
	int LITERAL_nvl = 215;
	int LITERAL_vsize = 216;
	int ONE_ARG_OP = 217;
	int TWO_ARG_OP = 218;
	int MINUS = 219;
	// "\u4e0e" = 220
	// "\u6216" = 221
	// "\u5f02\u6216" = 222
	// "\u52a0" = 223
	// "\u51cf" = 224
	// "\u4e58" = 225
	// "\u9664" = 226
	int COMPARE_OP = 227;
	int LITERAL_like = 228;
	// "\u5927\u4e8e\u7b49\u4e8e" = 229
	// "\u5c0f\u4e8e\u7b49\u4e8e" = 230
	// "\u5927\u4e8e" = 231
	// "\u5c0f\u4e8e" = 232
	// "\u4e0d\u7b49\u4e8e" = 233
	// "\u5305\u542b" = 234
	// "\u4e0d\u5305\u542b" = 235
	// "not exists" = 236
	// "\u4e0d\u5b58\u5728" = 237
	int LITERAL_exists = 238;
	// "\u5b58\u5728" = 239
	int NOT_EXIST = 240;
	int EXIST = 241;
	int PARAM_LPAREN = 242;
	int PARAM_RPAREN = 243;
	int WS = 244;
	int ESC = 245;
	int ID_START_LETTER = 246;
	int ID_LETTER = 247;
	int NUM = 248;
	int DOT_NUM = 249;
	int NUM_START = 250;
	int NUM_LETTER = 251;
	int ML_COMMENT = 252;
}
